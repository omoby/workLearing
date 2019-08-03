package runoob

/**
  *
  * @ClassName CallByNameTest
  * @Author zhangqx02
  * @Date 2019/8/3 18:05
  * @Description
  *
  *
  */

object CallByNameTest {

  def main(args: Array[String]): Unit = {
    delayed(time())
  }

  def time()={
    println("获取的时间，单位为秒")
    System.nanoTime()
  }

  def delayed(t:Long)={
    println("在delayed的方法内")
    println("参数： "+t)
    t
  }

}
