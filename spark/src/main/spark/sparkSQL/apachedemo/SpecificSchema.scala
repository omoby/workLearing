package sparkSQL.apachedemo


import org.apache.spark.sql.{Encoders, Row, SparkSession}
import org.apache.spark.sql.types.{DataType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @ClassName SpecificSchema
  * @Author zhangqx02
  * @Date 2019/11/8 17:26
  * @Description
  *
  * 以编程的方式指定Schema
  * 当 case class 不能够在执行之前被定义（例如，records 记录的结构在一个 string 字符串中被编码了，或者一个 text 文本 dataset 将被解析并且不同的用户投影的字段是不一样的）。一个 DataFrame 可以使用下面的三步以编程的方式来创建。
  *
  * 从原始的 RDD 创建 RDD 的 Row（行）。
  * Step 1 被创建后，创建 Schema 表示一个 StructType 匹配 RDD 中的 Row（行）的结构。
  * 通过 SparkSession 提供的 createDataFrame 方法应用 Schema 到 RDD 的 RowS（行）。
  *
  *
  */

object SpecificSchema {
  def main(args: Array[String]): Unit = {
    val ip = "spark://Master:7077"
    val conf = new SparkConf()
      .setAppName("SpecificSchema")
      .setMaster(ip)
    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()

    //Create an RDD
    val peopleRDD = spark
      .sparkContext
      .textFile("file:/usr/local/spark/examples/src/main/resources/people.txt")
    //The schema is encoded in a string
    val schemaString = "name age"
    def StringType:DataType =StringType;
    //Generate the schema based on the string of schema
    val fields = schemaString.split(" ")
      .map(fieldName => StructField(fieldName, StringType, nullable = true))
    val schema = StructType(fields)
    //Convert records of the RDD (people) to Rows
    val rowRDD = peopleRDD
      .map(_.split(","))
      .map(attributes => Row(attributes(0),attributes(1).trim))
    //Apply the schema to the RDD
    val peopleDF = spark.createDataFrame(rowRDD,schema)
    //Creetes a temporary view using the DataFrame
    peopleDF.createOrReplaceTempView("people")
    //SQL can be run over a temporary view create usding DataFrame
    val results = spark.sql("SELECT name FROM people")
    //The results of SQL queries are DataFrame ans support all the normal RDD operations
    //The  columns of a row in the result can be accessed by field index or by field name
    results.map(attributes=>"Name:"+attributes(0))(Encoders.kryo[String]).show()
  }

}
