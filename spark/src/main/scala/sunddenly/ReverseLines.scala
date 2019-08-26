package sunddenly

import java.io.PrintWriter

import scala.io.Source

/**
  *
  * @ClassName ReverseLines
  * @Author zhangqx02
  * @Date 2019/8/26 11:11
  * @Description
  *
  *1. 编写一小段Scala代码，将某个文件中的行倒转顺序，将最后一行作为第一行,依此类推
  */

object ReverseLines {

  def main(args: Array[String]): Unit = {
    val fileDir = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
    val fileName = "File.txt"
    val reFileName  = "ReverseFile.txt"

    val source = Source.fromFile(fileDir+fileName)
    lazy val reSource = Source.fromFile(fileDir+reFileName)
    lazy  val pw = new PrintWriter(fileDir+reFileName)

    val linesItrator = source.getLines()

    val linesRecord = linesItrator.toArray
    val reverseRecord = linesRecord.reverse

    reverseRecord.foreach(line => pw.write(line +"\n"))
    pw.close()

    println(fileName +" 文件内容如下：")
    println()
    for (elem <- linesRecord) {
      println(elem)
    }
    println()

    println(reFileName + " 文件内容如下：")
    println()
    reSource.getLines().foreach(line => println(line))
  }

}
