package sunddenly

import scala.util.Random

/**
  *
  * @ClassName RandomArray
  * @Author zhangqx02
  * @Date 2019/8/16 11:17
  * @Description
  * 编写一段代码，将a设置为一个包含n个随机整数的数组，要求随机数介于0（包含）和n（不包含）之间
  *
  */

object RandomArray {
  def main(args: Array[String]): Unit = {
    val array = randomArray(10)
    println(array.toBuffer.toString())
  }

def randomArray(n:Int):Array[Int]={
  val arr = new Array[Int](n)

  for (i <- 0 until  n){
    arr(i) = new Random().nextInt(n)
  }
  arr
}
}
