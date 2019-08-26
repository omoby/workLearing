package sunddenly

import java.io.PrintWriter

import scala.io.Source


/**
  *
  * @ClassName TabSpace
  * @Author zhangqx02
  * @Date 2019/8/26 11:31
  * @Description
  *
  * 2. 编写Scala程序，从一个带有制表符的文件读取内容，将每个制表符替换成一组空格，使得制表符隔开的n列仍然保持纵向对齐，并将结果写入同一个文件
  *
  */

object TabSpace {
  def main(args: Array[String]): Unit = {
    val fileName = "tabSpace"
    val replaceFileName = "replaceTabSpace"
    val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
    val fileDir = path +fileName+".txt"
    val reFileDir = path +replaceFileName +".txt"

    val linesIterator = Source.fromFile(fileDir).getLines()
    lazy val pw = new PrintWriter(reFileDir)
    val linesRecord = linesIterator.toArray

    println(fileName+" 内容如下：")
    linesRecord.foreach(line=>println(line))

    linesRecord.foreach(line=>pw.write(line.replace("\t"," "))+"\n")
    pw.close()
    println()
    val linesTabIterator = Source.fromFile(reFileDir).getLines()
    println(replaceFileName+" 内容如下：")
    linesTabIterator.foreach(line=>println(line))

  }

}
