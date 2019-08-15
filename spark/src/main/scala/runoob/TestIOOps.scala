package runoob

import java.io.{File, PrintWriter}

import scala.io.{Source, StdIn}

/**
  *
  * @ClassName TestIOOps
  * @Author zhangqx02
  * @Date 2019/8/15 8:20
  * @Description
  *
  *
  */

object TestIOOps {
  def main(args: Array[String]): Unit = {
//    iOOps()
    readLineOps()
//  readFileOps()
  }

  def iOOps(): Unit ={
    val writer = new PrintWriter(new File("test.txt"))

    writer.write("Hello World")
    writer.close()
  }

  def readLineOps(): Unit ={
    println("请输入菜鸟教程官网")
    val line = StdIn.readLine()
    println("谢谢，你输入的是： "+line)
  }

  def  readFileOps(): Unit ={
    println("文件内容为：")
    Source.fromFile("test.txt").foreach(
      print
    )
  }
}
