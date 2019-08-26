package sunddenly

import scala.io.Source

/**
  *
  * @ClassName RegExp
  * @Author zhangqx02
  * @Date 2019/8/26 15:02
  * @Description
  *
  *6. 编写正则表达式，匹配Java或C++程序代码中类似"like this，maybe with \" or\\"这样的带引号的字符串。编写Scala程序将某个源文件中所有类似的字符串打印出来
  */

object RegExp extends App{
  val fileName="regexp"
  val path="D:\\MyFile\\workLearning\\spark\\src\\files\\"+fileName+".txt"
  val pat1=""""like this，maybe with \\" or\\{2}"""".r
  val pat2="""like this，maybe with \\" or\\{2}""".r
  val pat3="""\w+\s+\\"""".r
  val linesIterator1=Source.fromFile(path).getLines()
  val linesIterator2=Source.fromFile(path).getLines()
  val linesIterator3=Source.fromFile(path).getLines()
  println("文本中包含:"+""""like this，maybe with \" or\\"""")
  linesIterator1.foreach(line=>pat1.findAllIn(line).foreach (println))
  println("文本中包含:"+"""like this，maybe with \" or\\""")
  linesIterator2.foreach(line=>pat2.findAllIn(line).foreach (println))
  println("文本中包含:"+"\\w+\\s+\"")
  linesIterator3.foreach(line=>pat3.findAllIn(line).foreach(println))
}