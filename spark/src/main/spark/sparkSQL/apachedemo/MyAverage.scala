package sparkSQL.apachedemo

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

/**
  *
  * @ClassName MyAverage
  * @Author zhangqx02
  * @Date 2019/11/12 16:00
  * @Description
  *用户自定义函数
  *
  */

//／用户定义的无类型聚合函数必须继承 UserDefinedAggregateFunction 抽象类
object MyAverage extends UserDefinedAggregateFunction{
  //／聚合函数输入参数的数据类型（其实是该函数所作用的 DataFrame 指定列的数据类型）
  override def inputSchema: StructType = StructType(StructField("inputColumn",LongType)::Nil)
  //聚合函数的缓冲器结构，如下，定义了用于记录累加值和累加数的字段结构
  override def bufferSchema: StructType = {
    StructType(StructField("sum",LongType)::StructField("count",LongType)::Nil)
  }
  //聚合函数返回值的数据类型
  override def dataType: DataType = DoubleType
  //次函数是否始终在相同输入上返回相同的输出
  override def deterministic: Boolean = true
  //初始化给定的 buffer 聚合缓冲器。
  // buffer 聚合缓冲器其本身是一个“Row”对象，因此可以调用其标准方法访问 buffer内的元素，例如在索引处检索一个值(例如， get(), getBoolean(), getLong())， 也可以根据索引更新其值。需注意， buffer内的 Array、 Map 对象仍然是不可变的。
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }

  //update 函数负责将 input 代表的输入数据更新到 buffer 聚合缓存器中， buffer缓冲器记录着累加和（buffer(0)）与累加数（buffer(1))
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    buffer(0) = buffer.getLong(0) + input.getLong(0)
    buffer(1) = buffer.getLong(1) + 1
  }

  //合并两个 buffer 聚合缓冲器（buffer1, buffer2 ）的部分累加和、累加次数，更新到 buffer1主聚合缓冲器。
  // buffer1为主聚合缓冲器，其代表着各个节点得到的部分结果经聚合后得到的最终结果， 而 buffer2代着各个分布式任务执行节点的部分执行结果 buffer2，因此 merge （）的重写实质上是实现 buffer1与多个buffer2的合并逻辑
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  //计算最终结果
  override def evaluate(buffer: Row): Double = buffer.getLong(0).toDouble / buffer.getLong(1)


  def main(args: Array[String]): Unit = {
    val  conf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("Spark SQL自定义函数")
    val  spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
    //／需要特别注意的是，若是想在 sql 语句中使用用户自定义函数，必须先将函数进行注册
    spark.udf.register("myAverage",MyAverage)
    val filePath = "file:/usr/local/spark/examples/src/main/resources/employees.json"
    val df = spark.read.json(filePath)
    df.createOrReplaceTempView("employees")
    df.show()
    val results = spark.sql("SELECT myAverage(salary) AS average_salary FROM employees")
    results.show()

  }
}
