package sunddenly

/**
  *
  * @ClassName ScalaTest2
  * @Author zhangqx02
  * @Date 2019/8/16 10:33
  * @Description
  *
  *
  */

object ScalaTest2 {
  def main(args: Array[String]): Unit = {
//    val str = "Hello"
//    val res = recursive(str)
//    println(res)
    println(xn(2,5))


  }

  /**
    *递归调用
    * @param str
    * @return
    */
  def recursive(str:String):Long = {
    if(str.length ==1)
      str.charAt(0).toLong
    else
      str.charAt(0).toLong * recursive(str.drop(1))
  }

  /**
    * 回归调用
    * @param x
    * @param n
    * @return
    */
  def xn(x:Double,n:Int):Double ={
    if (n == 0)
      1
    else if(n < 0)
      1/xn(x,-n)
    else if(n % 2 ==0)
      xn(x,n/2)*xn(x,n/2)
    else
      x * xn(x,n-1)
  }

}
