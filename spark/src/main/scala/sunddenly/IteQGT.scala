package sunddenly

/**
  *
  * @ClassName IteQGT
  * @Author zhangqx02
  * @Date 2019/8/19 18:46
  * @Description
  *编写一个函数lteqgt(values: Array[lnt]，v：Int)，返回数组中小于v、等于v和大于V的数量，要求三个值一起返回
  *
  */

object IteQGT {

  def main(args: Array[String]): Unit = {
    val array:Array[Int] = Array(1,2,3,4,5,6)
    val tuple3 = iteGT(array,3)
    println("low: "+ tuple3._1 +" equals: "+ tuple3._2+ " lager； "+ tuple3._3)
  }

  def iteGT(arr:Array[Int],v:Int):Tuple3[Int,Int,Int]={
    var low = 0
    var equal = 0
    var lager = 0
    for(elem <- arr){
      if (elem < v){
        low += 1
      }else if(elem == v){
        equal += 1
      }else{
        lager += 1
      }
    }
    (low,equal,lager)
  }

}
