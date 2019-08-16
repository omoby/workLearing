package sunddenly

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @ClassName SigArray
  * @Author zhangqx02
  * @Date 2019/8/16 16:43
  * @Description
  *
  *给定一个整数数组，产出一个新的数组，包含元数组中的所有正值，以原有顺序排列，之后的元素是所有零或负值，以原有顺序排列
  */

object SigArray {

  def main(args: Array[String]): Unit = {
    val arr = Array(1,-2,0,-3,1,2)
    val b = sigArray(arr)
    b.foreach(elem=>print(elem + "\t"))
  }

  def sigArray(arr:Array[Int]) ={
    val buff = new ArrayBuffer[Int]()
    buff ++=(
      for(elem <- arr if elem >0)
        yield elem
    )
    buff ++= (
      for (elem <- arr if elem ==0)
        yield elem
    )

    buff ++=(
    for(elem <- arr if elem < 0)
      yield elem
      )

    buff.toArray
  }

}
