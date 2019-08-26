package sunddenly

import scala.io.Source

/**
  *
  * @ClassName ChechString
  * @Author zhangqx02
  * @Date 2019/8/26 13:49
  * @Description
  *
  *3. 编写一小段Scala代码，从一个文件读取内容并把所有字符数大于12的单词打印到控制台。如果你能用单行代码完成会有额外奖励
  */

object ChechString extends App{
  val fileName = "file.txt"
  val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
  println(fileName+" 文件中长度大于6的字符串为：")
  Source.fromFile(path+fileName).mkString.split("\\s+").foreach(string => if(string.length >6) println(string))

}
