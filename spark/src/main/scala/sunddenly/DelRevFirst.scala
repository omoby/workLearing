package sunddenly

/**
  *
  * @ClassName DelRevFirst
  * @Author zhangqx02
  * @Date 2019/8/16 17:13
  * @Description
  *
  *收集负值元素的下标，反序，去掉最后一个下标，然后对每一个下标调用a.remove(i)。
  */

object DelRevFirst {

  def main(args: Array[String]): Unit = {
    val a=Array(1,-2,3,4,5,-1,-3,-4)
    println("Execute delRevFirst: "+ a.toBuffer.toString())
    val b = delRevFirst(a)
    println("Execute after: "+ b.toBuffer.toString())
  }

  def delRevFirst(arr:Array[Int]):Array[Int]={
    val index = for (i <- 0 until(arr.length) if arr(i) < 0) yield i
    println("index: "+ index.toBuffer.toString())
    val dropIndex = index.reverse.dropRight(1)
    println("dropIndex: "+ dropIndex.toBuffer.toString())
    val buffer = arr.toBuffer
    for (elem <- dropIndex)
      buffer.remove(elem)

    buffer.toArray
  }


}
