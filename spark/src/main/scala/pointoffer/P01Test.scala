package pointoffer

/**
  *
  * @ClassName P01Test
  * @Author zhangqx02
  * @Date 2019/12/9 17:11
  * @Description
  *
  *
  */

object P01Test {
  def main(args: Array[String]): Unit = {
    val array = Array.ofDim[Int](4,4)
    array(0) = Array(1,2,8,9)
    array(1) = Array(2,4,9,12)
    array(2) = Array(4,7,10,13)
    array(3) = Array(6,8,11,15)
    val p01 = new P01()
    val startTime = getCurrentTime()
    p01.find(4,array)
    val endTime = getCurrentTime()
    println("Used Time: "+ (endTime-startTime))
  }
  def getCurrentTime() ={
    val sysTime = System.currentTimeMillis()
    sysTime
  }
}
