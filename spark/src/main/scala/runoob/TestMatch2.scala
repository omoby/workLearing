package runoob

/**
  *
  * @ClassName TestMatch2
  * @Author zhangqx02
  * @Date 2019/8/14 17:05
  * @Description
  *
  *Scala模式匹配
  */

object TestMatch2 {


  def matchTest(x:Any):Any = x match {
    case 1 => "one"
    case "two" => 2
    case "Int" => "Scala.Int"
    case _ => "Any"
  }

  def main(args: Array[String]): Unit = {
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(6))
  }

}
