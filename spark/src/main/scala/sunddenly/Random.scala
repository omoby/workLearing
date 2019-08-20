package sunddenly

/**
  *
  * @ClassName Random
  * @Author zhangqx02
  * @Date 2019/8/20 15:35
  * @Description
  *
  *3. 编写一个包random，加入函数nextlnt(): Int、nextDouble(): Double和setSeed(seed : Int): Unit。生成随机数的算法采用线性同余生成器：
  *
  * 后值 =（前值×a+b）mod 2n
  *
  * 其中，a = 1664525，b =1013904223，n =32，前值的初始值为seed。
  */


package random{
  object Random{
    private val a = 1664525
    private val b = 1013904223
    private val c = 32

    private var seed = 0
    private var follow:BigInt = 0
    private var previous:BigInt = 0
//   val bigInteger = math.BigDecimal(Int(math.pow(2,32))
    def nextInt():Int={
      follow = (previous * a + b) % BigInt(math.pow(2,32).toLong)
      previous = follow
      (follow % Int.MaxValue).intValue()
    }

    def nextDouble():Double={
      nextInt().toDouble
    }

    def setSeed(newSeed:Int): Unit ={
      seed = newSeed
      previous = seed
    }
  }

}
object Test extends App {
  val rand = random.Random
  rand.setSeed(args(0).toInt)
  for (i <- 1 to 10)
    println(rand.nextInt())
  for(i <- 1 to 10)
    println(rand.nextDouble())

}

//package random{
//  object Random {
//    private val a = 1664525
//    private val b = 1013904223
//    private val n = 32
//
//    private var seed=0
//    private var follow:BigInt=0
//    private var previous:BigInt=0
//
//    def nextInt():Int={
//      follow=(previous*a+b)%BigInt(math.pow(2, n).toLong)
//      previous=follow
//      (follow%Int.MaxValue).intValue()
//    }
//    def nextDouble():Double={
//      nextInt.toDouble
//    }
//    def setSeed(newSeed:Int){
//      seed=newSeed
//      previous=seed
//    }
//  }
//}
//object RandomTest extends App{
//  var r =random.Random
//  r.setSeed(10000)
//  for(i <- 1 to 10) println(r.nextInt())
//  for(i <- 1 to 10) println(r.nextDouble())
//}
