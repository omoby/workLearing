package sparkCore.demo

import org.apache.spark.{SparkConf, SparkContext}

object WordCount extends Serializable {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("spark://Master:7077")
      .setAppName("WordCount demo")
    val sc = new SparkContext(conf)
//    sc.addJar("/usr/local/spark/jars/")
    val filePath = "file:/usr/local/spark/README.md"
    val words = sc.textFile(filePath).flatMap(line=>line.split(" "))
    val wordPair = words.map(word=>(word,1))
    val wordCount = wordPair.reduceByKey((a,b)=>a+b)
    val reducedWords = wordCount.collect()
    reducedWords.foreach(println)
  }
}
