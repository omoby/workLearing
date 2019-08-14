package runoob

/**
  *
  * @ClassName TestClosure
  * @Author zhangqx02
  * @Date 2019/8/14 8:38
  * @Description
  *测试scala闭包
  *
  */

object TestClosure {

  val factor  = 3
  val multipler = (i : Int) => i * factor

  def main(args: Array[String]): Unit = {
    println("muliplier(1) value = "+ multipler(1))
    println("muliplier(2) value = "+ multipler(2))
  }

}
