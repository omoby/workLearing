package sunddenly

/**
  *
  * @ClassName AverageArray
  * @Author zhangqx02
  * @Date 2019/8/16 16:50
  * @Description
  *如何计算Array[Double]的平均值
  *
  */

object AverageArray {

  def main(args: Array[String]): Unit = {
    val arr = Array[Double](1,4,2,10,3,-1,-3)
    val result = averageArr(arr)
    println(result)
  }

  def averageArr(arr:Array[Double]): Double ={
    arr.sum /arr.length
  }

}
