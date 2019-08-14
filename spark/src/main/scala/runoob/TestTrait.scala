
package runoob

/**
  *
  * @ClassName TestTrait
  * @Author zhangqx02
  * @Date 2019/8/14 16:41
  * @Description
  *
  *
  */

trait Equal{
  def isEqual(x:Any):Boolean
  def isNotEqual(x:Any) = !isEqual(x)
}

class Points(xc:Int,yc:Int) extends Equal {
  var x:Int = xc
  var y:Int = yc

  def isEqual(obj: Any): Boolean = obj.isInstanceOf[Points] && obj.asInstanceOf[Points].x == x
}
object TestTrait {
  def main(args: Array[String]): Unit = {
    val p1 = new Points(2,3)
    val p2 = new Points(2,4)
    val p3 = new Points(3,4)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }

}



/*
trait Equal{
  def isEqual(x:Any):Boolean
  def isNotEqual(x:Any) = !isEqual(x)
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc
  def isEqual(obj: Any) =
    obj.isInstanceOf[Point] &&
      obj.asInstanceOf[Point].x == x
}

object TestTrait {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}*/
