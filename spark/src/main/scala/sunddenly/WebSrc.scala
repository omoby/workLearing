package sunddenly

import scala.io.Source

/**
  *
  * @ClassName WebSrc
  * @Author zhangqx02
  * @Date 2019/8/26 15:29
  * @Description
  *
  *8. 编写Scala程序打印出某个网页中所有img标签的src属性。使用正则表达式和分组
  */

object WebSrc extends App{
  val pat = """<img.*?src=["'](.+?)["'].*?>""".r
  for (pat(src) <-pat.findAllIn(Source.fromURL("http://news.baidu.com/").mkString)) {
    println(src)
  }
}