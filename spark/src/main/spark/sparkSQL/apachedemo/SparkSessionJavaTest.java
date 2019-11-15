package sparkSQL.apachedemo;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.expressions.Aggregator;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.expressions.UserDefinedAggregateFunction;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.TypedColumn;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.spark.sql.functions.col;

/**
 * @Classname SparkSessionJavaTest
 * @Date 2019/11/14 下午7:00
 * @Auther hadoop
 * @Description:
 * SparkSQL Java版本
 */

public class SparkSessionJavaTest {
    public static void main(String[] args){
        Logger.getLogger("org").setLevel(Level.INFO);
        SparkConf conf = new SparkConf()
                .setAppName("SparkSessionJavaTest")
                .setMaster("local[2]");
        SparkSession spark = SparkSession
                .builder()
                .config(conf)
//                .enableHiveSupport()
                .getOrCreate();
        String filePath = "file:/usr/local/spark/examples/src/main/resources/";

//        dataFrameTest(spark,filePath);
//        datasetTest(spark,filePath);
//        inferringTheSchemaUsingReflection(spark,filePath);
//        programmaticallySpecifyingTheSchema(spark,filePath);
//        untypedUserDefineAggregateFunction(spark,filePath);
        typeSafeUserDefinedAggregateFunction(spark,filePath);
        spark.stop();
    }

    /**
     * 集合操作
     *自定义安全类型
     * @param spark
     * @param filePath
     */
    private static void typeSafeUserDefinedAggregateFunction(SparkSession spark,String filePath){
        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);
        String path = filePath+ "employees.json";
        Dataset<Employee> ds = spark.read().json(path).as(employeeEncoder);
        ds.show();
//        MyAverage2 myAverage = new MyAverage2();
//        //Covert the function to a "TypedColumn and five it a name "
//        TypedColumn<Employee,Double> averageSalary = myAverage.toColumn().name("average_salary");
//        Dataset<Double> result = ds.select(averageSalary);
//        result.show();
        MyAverage2 myAverage = new MyAverage2();
// Convert the function to a `TypedColumn` and give it a name
        TypedColumn<Employee, Double> averageSalary = myAverage.toColumn().name("average_salary");
        Dataset<Double> result = ds.select(averageSalary);
        result.show();

    }
    /**
     * 聚合操作
     * 自定义无类型聚合函数
     * @param spark
     * @param filePath
     */
    private static void untypedUserDefineAggregateFunction(SparkSession spark,String filePath){
        //Register the function to access it
        spark.udf().register("myAverage",new MyAverage());
        Dataset<Row> df = spark.read().json(filePath+"employees.json");
        df.createOrReplaceTempView("employees");
        df.show();
        Dataset<Row> result = spark.sql("SELECT myAverage(salary) FROM employees");
        result.show();
    }

    /**
     * 与RDDs互操作
     * 编程指定schema
     * @param spark
     * @param filePath
     */
    private static void programmaticallySpecifyingTheSchema(SparkSession spark,String filePath){
        //Create an RDD
        JavaRDD<String> peopleRDD = spark
                .sparkContext()
                .textFile(filePath+"people.txt",1)
                .toJavaRDD();

        //The schema is encodee in a string
        String schemaString = "name age";
        //Generate the schema based on the string of schema
        List<StructField> fields = new ArrayList<>();
        for (String fieldName: schemaString.split(" ")){
            StructField field = DataTypes.createStructField(fieldName,DataTypes.StringType,true);
            fields.add(field);
        }
        StructType schema = DataTypes.createStructType(fields);
        //Convert records of the RDD (people) to Rows
        JavaRDD<Row> rowRDD = peopleRDD.map(
                (Function<String,Row>) record ->{
                    String[] attribute = record.split(",");
                    return RowFactory.create(attribute[0],attribute[1].trim());
                }
        );

        //Apply the schema to the RDD
        Dataset<Row> peopleDataFrame = spark.createDataFrame(rowRDD,schema);
        //Creates a temporay view using the DataFrame
        peopleDataFrame.createOrReplaceTempView("people");

        //SQL can be run over a temporay view created using DataFrame
        Dataset<Row> results = spark.sql("SELECT name FROM people");

        //The results of SQL queries are DataFrames and support all the normal RDD operations
        //The columns of a row in the result can be accessed bu field index or by field name
        Dataset<String> namesDS = results.map(
                (MapFunction<Row,String>) row -> "Name:"+row.getString(0),Encoders.STRING()
        );
        namesDS.show();

    }

    /**
     * 与RDDs互操作
     * 反射推断出schema
     * @param spark
     * @param filePath
     */
    private static void inferringTheSchemaUsingReflection(SparkSession spark,String filePath){
        //Create an RDD of Person objects from a text file
        JavaRDD<Persons> peopleRDD = spark.read()
                .textFile(filePath+"people.txt")
                .javaRDD()
                .map(line ->{
                    String[] parts = line.split(",");
                    Persons persons = new Persons();
                    persons.setName(parts[0]);
                    persons.setAge(Integer.parseInt(parts[1].trim()));
                    return persons;
        });

        //Apply a schema to an RDD of javaBeans to get  a DataFrame
        Dataset<Row> peopleDF = spark.createDataFrame(peopleRDD,Persons.class);
        //Register the DataFrame as a temporay view
        peopleDF.createOrReplaceTempView("people");

        //SQL statements can be run by using the sql methods providing by  spark
        Dataset<Row> teenagersDF = spark.sql("SELECT name FROM people WHERE age BETWEEN 13 AND 19");
        //The columns of a row in the result can be accessed by field index
        Encoder<String> stringEncoder = Encoders.STRING();
        Dataset<String> teenagerNamesByIndexDF = teenagersDF.map(
                (MapFunction<Row,String>) row -> "Name:"+row.getString(0),
                stringEncoder
        );
        teenagerNamesByIndexDF.show();

        //or by field name
        Dataset<String> teenagerNamesByFieldDF = teenagersDF.map(
                (MapFunction<Row,String>)  row -> "Name:"+row.<String>getAs("name"),
                stringEncoder
        );
        teenagerNamesByFieldDF.show();
    }

    /**
     *学习Dataset相关知识
     * @param spark
     * @param filePath
     */
    private static void datasetTest(SparkSession spark,String filePath){
//        //Create an instance of a Bean class
//        Persons persons = new Persons();
//        persons.setName("Andy");
//        persons.setAge(32);
//
//        //Encoders are created for Java beans
//        Encoder<Persons> personEncoder = Encoders.bean(Persons.class);
//        Dataset<Persons> javaBeanDS = spark.createDataset(Collections.singletonList(persons), personEncoder);
//        javaBeanDS.show();
        // Create an instance of a Bean class
        Persons persons = new Persons();
        persons.setName("Andy");
        persons.setAge(32);

// Encoders are created for Java beans
        Encoder<Persons> personEncoder = Encoders.bean(Persons.class);
        Dataset<Persons> javaBeanDS = spark.createDataset(
                Collections.singletonList(persons),
                personEncoder
        );
        javaBeanDS.show();
        List<String> list = Arrays.asList("hello","world");
        Dataset<String> datasetList = spark.createDataset(list,Encoders.STRING());
        datasetList.show();

        //Encoders for most commin types are provided in class Encoders
        Encoder<Integer> integerEncoder = Encoders.INT();
        Dataset<Integer> primitiveDS = spark.createDataset(Arrays.asList(1,2,3),integerEncoder);
        Dataset<Integer> transformedDS = primitiveDS.map(
                (MapFunction<Integer,Integer>) value -> value + 1, integerEncoder);
        List<Integer> collectList = transformedDS.collectAsList();
        System.out.println(collectList);


        //DataFrame can be converted to a Dataset by providing a class,Mapping bases on name
        String path = filePath+"people.json";
        Dataset<Persons> peopleDS = spark.read().json(path).as(personEncoder);
        peopleDS.show();
    }
    /**
     * dataFrame 操作
     * @param spark
     * @param filePath
     */
    private static void dataFrameTest(SparkSession spark, String filePath){
        Dataset<Row> df = spark.read().json(filePath+"people.json");
        df.cache();
        //Displays the content of the DataFrame to stdout
        df.show();
        //Print the schema in a tree format
        df.printSchema();
        //Select only the "name" column
        df.select("name").show();

        //Select everybody,but increment the age by 1
        df.select(col("name"), col("age").plus(1)).show();
        //Select people older than 21
        df.filter(col("age").gt(21)).show();
        //Count people by age
        df.groupBy("age").count().show();

        //Register the DataFrame as a SQL temporay view
        df.createOrReplaceTempView("people");

        Dataset<Row> sqlDF = spark.sql("SELECT * FROM people");
        sqlDF.show();

        //Register the DataFrame as a global temporay view
        try {
            df.createGlobalTempView("gpeople");
        } catch (AnalysisException e) {
            e.printStackTrace();
        }
        //Global temporay view is tied to a system preserved database 'global_temp'
        spark.sql("SELECT * FROM global_temp.gpeople").show();
        //Global temporay viw is cross-session
        spark.newSession().sql("SELECT * FROM global_temp.gpeople").show();
    }
    public static class Persons implements Serializable{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    /**
     * Employee内部类
     */
    public static class Employee implements Serializable{
        private String name;
        private long salary;

//        public Employee(String name, long salary) {
//            this.name = name;
//            this.salary = salary;
//        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }
    }

    /**
     * Average 内部类
     */
    public static class  Average implements Serializable{
        private long sum;
        private long count;

//        public Average(long sum, long count) {
//            this.sum = sum;
//            this.count = count;
//        }

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }

    public static class MyAverage2 extends Aggregator<Employee,Average,Double> {
        //A zero value for this aggregation.Should satisfy the property taht any b + zero = b
        public Average zero(){
            Average average = new Average();
            average.setSum(0L);
            average.setCount(0L);
            return average;
//            return new Average(0L,0L);
        }
        //Combine tow values to produce a new value. For performance,the function may modify 'buffer'
        //and return it instead of constructing a new object
        public Average reduce(Average buffer,Employee employee){
            long newSum = buffer.getSum() + employee.getSalary();
            long newCount = buffer.getCount() + 1;
            buffer.setSum(newSum);
            buffer.setCount(newCount);
            return buffer;
        }
        //Merge tow intermediate values
        public Average merge(Average b1,Average b2){
            long mergeSum = b1.getSum() + b2.getSum();
            long mergeCount = b1.getCount() + b2.getCount();
            b1.setSum(mergeSum);
            b1.setCount(mergeCount);
            return b1;
        }
        //Transform the output of the reduction
        public Double finish(Average reduction){
            return ((double)reduction.getSum()) / reduction.getCount();

        }
        //Specifies the Encoder for the intermediate value type
        public Encoder<Average> bufferEncoder(){
            return Encoders.bean(Average.class);
        }
        //Specifies the Encoder for the final output value type
        public Encoder<Double> outputEncoder(){
            return Encoders.DOUBLE();
        }

    }
    /**
     * 自定义的集合函数
     */
    public static class  MyAverage extends UserDefinedAggregateFunction{
        private StructType inputSchema;
        private StructType bufferSchema;

        public MyAverage(){
            List<StructField> inputFields = new ArrayList<>();
            inputFields.add(DataTypes.createStructField("inputColumn",DataTypes.LongType,true));
            inputSchema = DataTypes.createStructType(inputFields);

            List<StructField> bufferFields = new ArrayList<>();
            bufferFields.add(DataTypes.createStructField("sum",DataTypes.LongType,true));
            bufferFields.add(DataTypes.createStructField("count",DataTypes.LongType,true));
            bufferSchema = DataTypes.createStructType(bufferFields);
        }

        //Data types of input arguments of the aggregate function
        @Override
        public StructType inputSchema() {
            return inputSchema;
        }
        //Data types of values in the aggregation buffer
        @Override
        public StructType bufferSchema() {
            return bufferSchema;
        }

        //The data type of the returned value
        @Override
        public DataType dataType() {
            return DataTypes.DoubleType;
        }

        //Whether this function always returns the same ouput on the identical input
        @Override
        public boolean deterministic() {
            return true;
        }

        //Initializes the given aggregation buffer,The buffer itself is a 'Row' that in addition to
        //standard methods like retrieving a value at an index (e.g.,get(),getBoolean()),provides
        //the opportunity to update its values.Note that arrays and maps inside the buffer are still immutable
        @Override
        public void initialize( MutableAggregationBuffer buffer) {
            buffer.update(0,0L);
            buffer.update(1,0L);
        }

        //Updates the given aggregation buffer 'buffer' with new input data 'input'
        @Override
        public void update( MutableAggregationBuffer buffer,  Row input) {
            long sum = buffer.getLong(0) + input.getLong(0);
            long count = buffer.getLong(1) + 1;
            buffer.update(0,sum);
            buffer.update(1,count);
        }

        //Merges two aggregation buffers and stores the update buffer values back to 'buffer1'
        @Override
        public void merge( MutableAggregationBuffer buffer1,  Row buffer2) {
            long sum = buffer1.getLong(0) + buffer2.getLong(0);
            long count = buffer1.getLong(1) + buffer2.getLong(1);
            buffer1.update(0,sum);
            buffer1.update(1,count);
        }

        //Calculates the final result
        @Override
        public Object evaluate( Row buffer) {
            return ((double) buffer.getLong(0)) / buffer.getLong(1);
        }
    }

}

//class Persons implements Serializable{
//    private String name;
//    private int age;
//
//     public String getName() {
//         return name;
//     }
//
//     public void setName(String name) {
//         this.name = name;
//     }
//
//     public int getAge() {
//         return age;
//     }
//
//     public void setAge(int age) {
//         this.age = age;
//     }
// }
