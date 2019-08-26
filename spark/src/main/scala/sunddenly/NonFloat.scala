package sunddenly

import scala.io.Source

/**
  *
  * @ClassName NonFloat
  * @Author zhangqx02
  * @Date 2019/8/26 15:13
  * @Description
  *
  *7. 编写Scala程序，从文本文件读取内容，并打印出所有的非浮点数的词法单位。要求使用正则表达式
  */

object NonFloat extends App{
  val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
  val source = Source.fromFile(path+"numberFile.txt").mkString
  val pat1 = """[^((\d+\.){0,1}\d+)^\s+]+$""".r//去掉+试试
  val pat2 = """^((?!^[-]?\d*\.\d+$).)+$""".r
  println("模式1不包含整数:")
  for(token <- source.split("\\s+")){
    for(word <- pat1.findAllIn(token))
      if(!word.equals("")){
        println(token)
      }
  }
  println()
  println("模式2包含整数:")
  for(token <- source.split("\\s+")){
    for(word <- pat2.findAllIn(token))
      println(word)
  }
}