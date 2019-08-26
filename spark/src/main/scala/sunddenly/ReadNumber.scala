package sunddenly

import scala.io.Source

/**
  *
  * @ClassName ReadNumber
  * @Author zhangqx02
  * @Date 2019/8/26 13:56
  * @Description
  *
  *4. 编写Scala程序，从包含浮点数的文本文件读取内容，打印出文件中所有浮点数之和，平均值，最大值和最小值
  */

object ReadNumber  extends App{
  val pattern = "(\\d+[.]\\d+)".r
  val pattern1 = "^\\d+(\\.\\d+)?".r
  val pattern2 = "[0-9]+(\\.\\d+)?".r
  val  fileName = "numberFile"
  val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
  val fileStr  = Source.fromFile(path+fileName+".txt").mkString
  val strArray = pattern2.findAllIn(fileStr).toArray
  var total = 0d
  val len = strArray.length
  strArray.foreach(number => println(number+" "))
  strArray.foreach(total+= _.toDouble)
  println("文本中浮点数的总和："+total)
  println("文本中浮点数的平均数："+total/len)
  println("文本中浮点数最大值："+strArray.max)
  println("文本中浮点数最小值："+strArray.min)

}
