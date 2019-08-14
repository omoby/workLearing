package runoob

/**
  *
  * @ClassName TestMap
  * @Author zhangqx02
  * @Date 2019/8/14 8:21
  * @Description
  *
  *
  */

object TestMap {
  def ttt(f:Int=>Int)={
    val  r = f(10)
    println(r)
  }

  val f0 = (x:Int) => x * x
  //定义一个方法
  def m0(x:Int)={
    x * 10
  }
  //将方法转化为函数
  val f1 = m0 _

  def main(args: Array[String]): Unit = {
    ttt(f0)

    //通过m0 _将方法转化为函数
    ttt(m0 _)
    //如果直接传递的是方法名称，scala相当于是把方法转成了函数
    ttt(m0)
    //通过x => m0(x)的方式将方法转化成函数,这个函数是一个匿名函数，等价：(x:Int) => m0(x)
    ttt(x=>m0(x))
  }

}
