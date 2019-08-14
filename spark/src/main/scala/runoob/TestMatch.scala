package runoob

/**
  *
  * @ClassName TestMatch
  * @Author zhangqx02
  * @Date 2019/8/14 17:02
  * @Description
  *
  *
  */

object TestMatch {
  def matchTest(x:Int):String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def main(args: Array[String]): Unit = {
    println(matchTest(2))
  }
}
