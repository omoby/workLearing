package runoob

import scala.util.matching.Regex

/**
  *
  * @ClassName TestRegex
  * @Author zhangqx02
  * @Date 2019/8/14 17:30
  * @Description
  *
  *Scala正则表达式
  */

object TestRegex {
  def main(args: Array[String]): Unit = {
//    val pattern = "Scala".r
//    val str = "Scala is scalabale and cool"
//
//    println(pattern findFirstIn str)

    //使用 mkString( ) 方法来连接正则表达式匹配结果的字符串，并可以使用管道(|)来设置不同的模式
//    val pattern = new Regex("(S|s)cala") //// 首字母可以是大写 S 或小写 s
    val pattern = "(S|s)cala".r
    val str = "Scala is scalabale and cool"

//    println((pattern findAllIn  str).mkString(",")) // 使用逗号 , 连接返回结果

    //可以使用 replaceFirstIn( ) 方法来替换第一个匹配项，使用 replaceAllIn( ) 方法替换所有匹配项
    println(pattern replaceAllIn(str,"Java"))
  }

}
