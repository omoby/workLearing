package sunddenly

/**
  *
  * @ClassName ExchangeArray
  * @Author zhangqx02
  * @Date 2019/8/16 11:28
  * @Description
  *编写一个循环，将整数数组中相邻的元素置换。例如，Array(1,2,3,4,5) 经过置换后变为Array(2,1,4,3,5)
  *
  */

object ExchangeArray {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
//    exchange(arr)
    val resultArr = exchangeByYield(arr)
    resultArr.foreach(print)
  }


  def exchange(arr:Array[Int]): Unit ={
    println("Echange before: "+arr.toBuffer.toString())
    for(i <- 0 until (arr.length-1,2)){
      var tem = arr(i)
      arr(i)=arr(i+1)
      arr(i+1) = tem
    }
    println("Echange after: "+arr.toBuffer.toString())
  }

  def exchangeByYield(arr:Array[Int])={
    for (i <- 0 until(arr.length))yield {
      if (i < arr.length-1 && i % 2==0){
        var tem = arr(i)
        arr(i) = arr(i+1)
        arr(i+1) = tem
      }
      arr(i)
    }
  }




}
