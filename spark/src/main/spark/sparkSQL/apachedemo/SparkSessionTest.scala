package sparkSQL.apachedemo

import java.io.File

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StringType, StructField, StructType}
import org.apache.spark.sql.expressions.Aggregator


/**
 * @Classname SparkSessionTest
 * @Date 2019/11/13 下午7:27
 * @Auther hadoop
 * @Description:
 *spark sql官网示例
 */

//Case class defined
case class Person(name:String,age:Long)
case class Employee(name:String,salary:Long)
case class Average(var sum:Long,var count:Long)
case class Record(key:Int,value:String)

object SparkSessionTest {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("SparkSessionTest")
    val spark = SparkSession
      .builder()
      .appName("SparkSessionTest")
      .master("local")
      .enableHiveSupport()
//      .config(conf)
      .getOrCreate()

    val filePath = "file:/usr/local/spark/examples/src/main/resources/"

    dataFrameTest(spark)
    dataSetTest(spark)
    schemaUsingReflection(spark)
    specifyingTheSchema(spark)
    untypeUserDefinedAggregateFunctions(spark)
    typeSafeUserDefineAggregateFunction(spark)
    dataSourcesTest(spark)
    parquetFileTest(spark,filePath)
    schemaMergeTest(spark,filePath)
    jsonDatasets(spark,filePath)
    hiveTablesTest(spark,filePath)


    spark.stop()
  }

  /**
   * 操作hive表数据
   * @param spark
   * @param filePath
   */
  private def hiveTablesTest(spark:SparkSession,filePath:String): Unit ={
    //warehouseLocation points to the default location for manageed databases and tables
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath
//    val warehouseLocation = "/user/hive/warehouse"
//    val sparkSession = SparkSession
//      .builder()
//      .appName("Spark Hive Example")
////      .config("spark.sql.warehouse.dir",warehouseLocation)
//      .enableHiveSupport()
//      .getOrCreate()
    import spark.implicits._
    import spark.sql
    sql("use hive")
    sql("CREATE TABLE IF NOT EXISTS src (key INT,value STRING) USING hive")
//    sql("LOAD DATA LOCAL INPATH '"+filePath+"kv1.txt' INTO TABLE src ")

    //Queries are expressed in HiveQL
    sql("SELECT * FROM src").show()

    //Aggregation queries are also supported
    sql("SELECT COUNT(*) FROM src").show()
     //The results of SQL queries are  themselves DataFrame and support all normal functions
    val sqlDF = sql("SELECT key,value FROM src WHERE key < 10 ORDER BY key")

    //The items in DataFrames are of type Row.while allows you to access each column by ordinal
    val stringDS = sqlDF.map{
      case Row(key:Int,value:String)=>s"Key:$key, Value: $value"
    }
    stringDS.show()

    //You can also use DataFrame to create temporay views within a SparkSession
    val recordsDF = spark.createDataFrame((1 to 100).map(i => Record(i,s"val_$i")))
    recordsDF.createOrReplaceTempView("records")

    //Queries can then join DataFrame data with data stored in hive
    sql("SELECT * FROM records r JOIN src s ON r.key = s.key").show()

    //Prepare a Parquet data directory
    val dataDir = "file:/home/hadoop/IdeaProjects/workLearing/spark/src/files/qarquet_data"
    spark.range(10).write.mode("overwrite").parquet(dataDir)
    //Create a Hive external Parquet table
    sql("CREATE EXTERNAL TABLE IF NOT EXISTS hive_ints(key INT) STORED AS PARQUET LOCATION '$dataDir'")
    //The Hive External table shoulf already have data
    sql("SELECT * FROM hive_ints").show()
    //Turn on flag for Hive Dynamic Partitioning
    spark.sqlContext.setConf("hive.exec.dynamic.partition","true")
    spark.sqlContext.setConf("hive.exec.dynamic.partition.mode","nonstrict")
    //Create a Hive Partitioned tavle using DataFrame API


  }

  /**
   * 操作JSON格式数据
   * @param spark
   * @param filePath
   */
  private def jsonDatasets(spark:SparkSession,filePath:String): Unit ={
    //Primitive types(Int, String,etc) and product types(case classes) encoders are
    //supported by import spark.implicits._
    import spark.implicits._
    //A JSON dataset is pointed to by path
    //The path can be enither a single text file or a directory storing text file
    val path = filePath+"people.json"
    val peopleDF = spark.read.json(path)
    //The inferred schema can be visualized using the printSchema() method
    peopleDF.printSchema()

    //Create a temporay view using the DataFrame
    peopleDF.createOrReplaceTempView("people")

    //SQL statements can be run by using the sql methods providd by spark
    val teenagersNameDF = spark.sql("SELECT name FROM people WHERE age BETWEEN 13 AND 19")
    teenagersNameDF.show()

    //alternatively,a DataFrame can be created for a JSON dataset represected by
    //a Dataset[String] storing one JSON object per string
    val otherPeopleDataset = spark
      .createDataset("""{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}"""::Nil)

    val otherPeople = spark.read.json(otherPeopleDataset)
    otherPeople.show()
  }
  /**
   * 合并schema
   * @param spark
   * @param filePath
   */
  private def schemaMergeTest(spark:SparkSession,filePath:String): Unit ={
    //This is used to implicitly convert an RDD to a DataFrame
    import spark.implicits._
    //Create a simple DataFrame,store into a partition directory
    val squaresDF = spark.sparkContext.makeRDD(1 to 5).map(i =>(i,i*i)).toDF("value","square")
    squaresDF.write.mode("overwrite").parquet("data/test_table/key=1")

    //Create another DataFrame in a new partition directory
    //adding a new column and dropping an existing column
    val cubesDF = spark.sparkContext.makeRDD(6 to 10).map(i=>(i,i*i*i)).toDF("value","cube")
    cubesDF.write.mode("overwrite").parquet("data/test_table/key=2")

    //Read the partitioned table
    val mergedDF = spark.read.option("mergeSchema",true).parquet("data/test_table")
    mergedDF.printSchema()
    mergedDF.show()
  }

  /**
   * parquet 文件
   * @param spark
   * @param filePath
   */
  private def parquetFileTest(spark:SparkSession,filePath:String): Unit ={
    //Encoders for most common types are automatically provided by import spark.implicits._
    import spark.implicits._
    val peopleDF = spark.read.json(filePath+"people.json")
    //DataFrames can be saved as Parquet files,maintaining the schema information
    peopleDF.write.parquet("people.parquet")

    //Read int the parquet file created above
    //Parquet files are self-describing（自我描述） so the schema is preserved(保留)
    //The result of loading a Parquet file alse a DataFrame
    val parquetFileDF = spark.read.parquet("people.parquet")

    //Parquet files can also be used to create a temporay view and then used in SQL statements
    parquetFileDF.createOrReplaceTempView("parquetFile")
    val nameDF = spark.sql("SELECT name FROM parquetFile WHERE age BETWEEN 13 AND 19")
    nameDF.map(attributes=>"Name:"+attributes(0)).show()
  }

  /**
   *
   * spark 数据源操作测试
   * @param spark
   */
  private def dataSourcesTest(spark:SparkSession): Unit ={
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    val savePath = "/home/hadoop/IdeaProjects/workLearing/spark/src/files/"
    /**
     * save modes
     * ErrorIfExists
     * Append
     * Overwirte
     * Ignore
     */
    val userDF = spark.read.load(filePath+"users.parquet")
    userDF.select("name","favorite_color").write.mode("ignore").save(savePath+"namesAndFavColors.parquet")
    val peopleDF = spark.read.format("json").load(filePath+"people.json")
    peopleDF.select("name","age").write.format("parquet").mode("ignore").save(savePath+"nameAndAge.parquet")
    //To load a CSV file
    val peopleDFCsv = spark.read.format("csv")
      .option("sep",";")
      .option("inferSchema","true")
      .option("header",true)
      .load(filePath+"people.csv")
    peopleDFCsv.show()
    //Run SQL on files directly
    val sqlDF = spark.sql("SELECT * FROM parquet.`"+filePath+"users.parquet`")
    sqlDF.show()
    //Bucketing,sorting and Partitioning
    peopleDF.write.bucketBy(42,"name").sortBy("age").saveAsTable("people_bucketed")
    userDF.write.partitionBy("favorite_color").format("parquet").save("namesPartByColor.qarquet")
    userDF.write
      .partitionBy("favorite_color")
      .bucketBy(42,"name")
      .saveAsTable("users_partitioned_bucketed")

  }
  /**
   *测试聚合函数
   * 自定义安全类型聚合函数
   * @param spark
   */
  private def typeSafeUserDefineAggregateFunction(spark:SparkSession): Unit ={
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    import spark.implicits._
    val ds = spark.read.json(filePath+"employees.json").as[Employee]
    ds.show()

    //Convert the function to a 'TypedColumn' and give it a name
    val averageSalary = SalaryAverage2.toColumn.name("average_salary")
    val result = ds.select(averageSalary)
    result.show()
  }
  /**
   * 聚合
   * 用户自定义无类型聚合函数
   * @param spark
   */
  private def untypeUserDefinedAggregateFunctions(spark:SparkSession): Unit ={
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    //Register the function to access it
    spark.udf.register("salaryAverage",SalaryAverage)
    val df = spark.read.json(filePath+"employees.json")
    df.createOrReplaceTempView("employees")
    df.show()

    val result = spark.sql("SELECT salaryAverage(salary) as average_salary FROM employees")
    result.show()

  }

  /**
   * 编程指定Schema
   * @param spark
   */
  private def specifyingTheSchema(spark:SparkSession): Unit ={
    val  filePath = "file:/usr/local/spark/examples/src/main/resources/"
    //Create an RDD
    val peopleRDD = spark.sparkContext.textFile(filePath+"people.txt")
    //The schema id encoded in a string
    val schemaString = "name age"
    //Generate the schema based on the string of schema
    val fields = schemaString.split(" ")
      .map(fieldName => StructField(fieldName,StringType,nullable = true))
    val schema = StructType(fields)

    //Convert records of the RDD(people) to Rows
    val rowRDD = peopleRDD
      .map(_.split(","))
      .map(attributes => Row(attributes(0),attributes(1).trim))
    //Apply the schema to the RDD
    val peopleDF = spark.createDataFrame(rowRDD,schema)
    //Creates a temporay view using the DataFrame
    peopleDF.createOrReplaceTempView("people")
    //SQL can be run over a temporay view created using DataFrames
    val results = spark.sql("SELECT name FROM people")
    //The results of SQL queries are DataFrames an support all the normal RDD operations
    //The columns of a row in the result can be accessed by field index or by field name
    import spark.implicits._
    results.map(attributes => "Name:"+attributes(0)).show()
  }
  /**
   *使用反射推断schema
   * @param spark
   */
  private def schemaUsingReflection(spark:SparkSession): Unit ={
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    //For implicit converstions from RDDs to DataFrames
    import spark.implicits._
    //Create an RDD of Person objects from a text file,convert it to
    // a DataFrame
    val peopleDF = spark.sparkContext
      .textFile(filePath+"people.txt")
      .map(_.split(","))
      .map(attributes =>Person(attributes(0),attributes(1).trim.toInt))
      .toDF()
    //Register the DataFrame as a temporay view
    peopleDF.createOrReplaceTempView("people")
    //SQL statements can be run using the sql methods provided by Spark
    val teenagersDF = spark.sql("SELECT name,age FROM people WHERE age BETWEEN 13 AND 19")
    teenagersDF.persist()
    //The columns of a row in the result can be accessed by field index
    teenagersDF.map(teenager=>"Name:"+teenager(0)).show()
    //Or by field name
    teenagersDF.map(teenager=>"Name:" + teenager.getAs[String]("name")).show()
    //No pre-define encoders for Dataset[Map[K,V]],define explicitly
    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String,Any]]
    //Primitive types and case classes can be also define as
    //implicite val stringIntMapEncoder:Encoder[Map[String,Any]] = ExperssionEncoder

    //row.getValuesMap[T] retrieves multiple columns at once into a Map[String,T]
    val valueMap = teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name","age"))).collect()
    valueMap.foreach(println)
    teenagersDF.unpersist()

  }


  private def dataSetTest(spark:SparkSession): Unit ={
    //For implicits conversions like converting Seq to Dataset
    import spark.implicits._
    //Encoders are created fore case classes
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()

    //Encoders for most common types are automatically provided by import spark.implicits._
    val primitiveDS = Seq(1,2,3).toDS()
    primitiveDS.map(_ + 1).collect() //Returns:Array(2,3,4)
    //DataFrames can be converted to Dataset by providing a class.Mapping will be done by name
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    val peopleDS = spark.read.json(filePath+"people" +
      ".json").as[Person]
    peopleDS.show()


  }
  private def dataFrameTest(spark:SparkSession): Unit ={
    //For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    val filePath = "file:/usr/local/spark/examples/src/main/resources/"
    val df = spark.read.json(filePath+"people.json")
    df.cache()
    //Displays the content of the DataFrame to stdout
    df.show()

    //This import is needed to use the $-nonation
    import  spark.implicits._
    df.printSchema()
    //Select only the "name" column
    df.select("name").show()
    //Select everybody,but increment the age by 1
    df.select($"name",$"age"+1).show()
    //Select people older than 21
    df.filter($"age" > 21).show()
    //Count people by age
    df.groupBy("age").count().show()

    //Register the DateFrame as a SQL temporary view
    df.createOrReplaceTempView("people")
    val sqlDF = spark.sql("SELECT * FROM people")
    sqlDF.show()

    //Register the DataFrame as a global temporary view
    df.createGlobalTempView("gpeople")
    //Global temparay view is tied to a system preserved database "global_temp"
    spark.sql("SELECT * FROM global_temp.gpeople").show()
    //Global temporay view is cross-session
    spark.newSession().sql("SELECT * FROM global_temp.gpeople").show()
  }

}

/**
 * 自定义无类型聚合函数
 */
object SalaryAverage extends UserDefinedAggregateFunction{
  //Data types of input arguments of this aggregate function
  override def inputSchema: StructType = StructType(StructField("inputColumn",LongType)::Nil)
  //Data types of values in the aggregateing buffer
  override def bufferSchema: StructType = {
    StructType(StructField("sum",LongType)::StructField("count",LongType)::Nil)
  }
  //The data type of the returned  value
  override def dataType: DataType = DoubleType

  //Whether this function always returns the same output on the identical input
  override def deterministic: Boolean = true

  //Initializes the given aggregation buffer.The buffer itself is a "Row" that
  //in addition to standard methods like retrieving a value at ab index (e.g get(),getBoolean()),
  //provides the opportunity to update its values.Note tha arrays ans maos inside buffer are still
  //immutable
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }

  //Update the given aggregating buffer "buffer" with new input data from "input"
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getLong(0) + input.getLong(0)
    buffer(1) = buffer.getLong(1) + 1
  }

  //Merges two aggregation buffers and stores the udpated buffer value back to "buffer1"
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  //Calculates the final result
  override def evaluate(buffer: Row): Any = buffer.getLong(0).toDouble / buffer.getLong(1)
}

/**
 * 自定义安全类型聚合函数
 */
object SalaryAverage2 extends Aggregator[Employee,Average,Double]{
 //A zero value for this aggregation,Should satisfu the property that any b + zero = b
  def zero:Average = Average(0L,0L)
  //Combine two values to produce a new value.For performance,the function may modify 'buffer'
  //and return it instead of constructing a new object
  def reduce(buffer:Average,employee:Employee):Average = {
    buffer.sum  += employee.salary
    buffer.count += 1
    buffer
  }
  //Merge two intermediate values
  def merge(b1:Average,b2:Average): Average ={
    b1.sum += b2.sum
    b1.count += b2.count
    b1
  }
  //Transform the output of the reduction
  def finish(reduction:Average):Double = reduction.sum.toDouble / reduction.count
  //Specifies the Encoder for the internediate value type
  def bufferEncoder :Encoder[Average] = Encoders.product
  //Specifies the Encoder for the final output value type
  def outputEncoder:Encoder[Double] = Encoders.scalaDouble

}
