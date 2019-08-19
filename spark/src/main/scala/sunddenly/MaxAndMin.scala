package sunddenly

/**
  *
  * @ClassName MaxAndMin
  * @Author zhangqx02
  * @Date 2019/8/19 18:41
  * @Description
  *
  *编写一个函数minmax(values: Array[lnt])，返回数组中最小值和最大值的对偶
  */

object MaxAndMin {
  def main(args: Array[String]): Unit = {
    val array:Array[Int] = Array(1,2,3,4,5)
    val resultTuple:(Int,Int) = minmax(array)
    println(resultTuple._1+" "+ resultTuple._2)

  }

  def minmax(array: Array[Int]):Tuple2[Int,Int]={
    (array.min,array.max)
  }

}
