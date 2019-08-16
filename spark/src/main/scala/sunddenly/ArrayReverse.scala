package sunddenly

import org.apache.avro.SchemaBuilder.ArrayBuilder

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @ClassName ArrayReverse
  * @Author zhangqx02
  * @Date 2019/8/16 17:00
  * @Description
  *如何重新组织A r r a y [ I n t ] 的元素将它们以反序排列,对于ArrayBuffer[Int]你又会怎么做呢
  *
  */

object ArrayReverse {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    println(arr.reverse.toBuffer.toString)

    println(arrayReverse(arr).toBuffer.toString())

    val b = ArrayBuffer(1,2,3,4,5)
    val  c = ArrayBuffer[Int]()
    c ++= b.reverse
    println(c.toBuffer.toString())

  }


  def arrayReverse(arr:Array[Int]):Array[Int]={
    val leng = arr.length
    for(i <- 0 to(leng /2)){
      var tmp = arr(i)
      arr(i) = arr(leng-1-i)
      arr(leng-1-i) = tmp
    }
    arr
  }

}
