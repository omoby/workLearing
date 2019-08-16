package sunddenly

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @ClassName ArrayDistinct
  * @Author zhangqx02
  * @Date 2019/8/16 17:08
  * @Description
  * 编写一段代码，产出数组中的所有值，去掉重复项
  *
  */

object ArrayDistinct {

  def main(args: Array[String]): Unit = {
    val a = ArrayBuffer(1,2,3,4,1,2,4,2)
    val b = ArrayBuffer[Int]()
    b ++= a.distinct
    println(b.toString())
  }

}
