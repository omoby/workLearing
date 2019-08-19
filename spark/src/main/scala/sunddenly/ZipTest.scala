package sunddenly

/**
  *
  * @ClassName ZipTest
  * @Author zhangqx02
  * @Date 2019/8/19 18:54
  * @Description
  * 当你将两个字符串拉链在一起，比如＂Hello＂.zip(＂World＂)，会是什么结果，想出一个讲得通的用例
  *
  *
  * 在Scaladoc的StringOps中的zip方法定义如下:
  *
  * def zip[B] (that: GenIterable[B]) : String[(A, B)]
  *
  * GenIterable是可遍历对象需要包含的trait，对于String来说，它是可遍历的。但是它的遍历是遍历单个字母。 所以拉链就针对每个字母来进行
  *
  */

object ZipTest {
  def main(args: Array[String]): Unit = {
    val tuple = "Hello".zip("World")
    tuple.toMap
    tuple.foreach(println)
  }

}
