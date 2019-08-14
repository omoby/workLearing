package runoob

/**
  *
  * @ClassName TestIterator
  * @Author zhangqx02
  * @Date 2019/8/14 14:31
  * @Description
  *
  *
  */

object TestIterator {
  def main(args: Array[String]): Unit = {
    nextAndhasNext()
    minAndMax()
    sizeAndLength()

  }

  /**
    * 调用 it.next() 会返回迭代器的下一个元素，并且更新迭代器的状态。
    *
    * 调用 it.hasNext() 用于检测集合中是否还有元素。
    */
  def nextAndhasNext(): Unit ={
    println("------------------nextAndHasNext Header--------------------")
    val it = Iterator("Baidu","Google","Runoob","Taobo")

    while(it.hasNext){
      println(it.next())
    }

    println("------------------nextAndHasNext Footer--------------------")
  }

  /**
    * 使用 it.min 和 it.max 方法从迭代器中查找最大与最小元素
    */
  def minAndMax(): Unit ={
    println("------------------minAndMax Header--------------------")
    val iteratora = Iterator(1,4,2,-1,10,100)
    val iteratorb = Iterator(1,4,2,-1,10,100)


    println("min value = "+iteratora.min)
    println("max value = "+ iteratorb.max)
    println("------------------minAndMax Footer--------------------")

  }

  /**
    *  it.size 或 it.length 方法来查看迭代器中的元素个数
    */
  def sizeAndLength(): Unit ={
    println("------------------sizeAndLength Header--------------------")

    val ita = Iterator(1,2,4,-1,-10,88,90)
    val itb = Iterator(1,2,4,-1,-10,88,90)

    println("The iterator size = "+ ita.size)
    println("The iterator length = "+ itb.length)
//    println("The count = "+ ita.count(_<0))
    println("------------------sizeAndLength Footer--------------------")
  }

}
