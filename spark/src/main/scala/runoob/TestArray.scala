package runoob

/**
  *
  * @ClassName TestArray
  * @Author zhangqx02
  * @Date 2019/8/14 9:35
  * @Description
  *
  *
  */

object TestArray {

  def main(args: Array[String]): Unit = {

    myArray()
    myMatrix()
    myConcat()
    myRange()
  }
  //一维数组
  def myArray(): Unit ={
    println("---------------myArray Start-------------------------")
    var myList = Array(1,2,3,4,5,6,7,8,9)
    //输出所有数组元素
    for (x <- myList){
      println(x)
    }

    //计算数组所有元素的总和
    var sum = 0
    for (i <- 0 until(myList.length)){
      sum += myList(i)
    }
    println("sum = "+ sum)

    //查找数组中的最大元素
    var max = myList(0)
    for(j <- 1 to (myList.length-1)){
      if (myList(j) > max) max = myList(j)
    }
    println("max = "+max)
    println("---------------myArray End-------------------------")

  }



  //多维数组
  def myMatrix(): Unit ={
    println("---------------myMatrix Start-------------------------")

//    var matrix = Array.ofDim[Int](3,3)
    var matrix = new Array[Array[Int]](3)
    for (index <- 0 until matrix.length)
      matrix(index) = new Array[Int](3)
    //初始化矩阵

    for (i <- 0 to 2){
      for (j <- 0 to 2){
        matrix(i)(j)=  j
      }
    }
    //打印矩阵
    for( i <- 0 to 2){
      for (j <- 0 to 2){
        print(" "+ matrix(i)(j))
      }
      println()

    }
    println("---------------myMatrix end-------------------------")

  }

  /**
    * 拼接数组
    */
  def myConcat(): Unit ={
    println("---------------myConcat Start-------------------------")
    var myArr1 = Array(1,2,3)
    var myArr2 = Array(4,5,6)
    //拼接两个数组
    var myArr3 = Array.concat(myArr1,myArr2)
    for(x <- myArr3){
      println(x)
    }
    println("---------------myConcat End-------------------------")
  }

  def myRange(): Unit ={
    println("---------------myRange Start-------------------------")
    var arr1 = Range(1,20,2)
    var arr2 = Range(10,50,5)

    for(elem <- arr1)
      print(elem+" ")

    println()

    for (i <- 0 until arr2.length)
      print(arr2(i)+" ")

    println("---------------myRange Start-------------------------")
  }


}
