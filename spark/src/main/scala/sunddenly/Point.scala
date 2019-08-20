package sunddenly

/**
  *
  * @ClassName Point
  * @Author zhangqx02
  * @Date 2019/8/20 13:57
  * @Description
  *4.  定义一个Point类和一个伴生对象,使得我们可以不用new而直接用Point(3,4)来构造Point实例
  *
  * 描述：apply方法使用
  *
  */

class Point(x:Int,y:Int) {
  override def toString():String = "x= "+x+" y= "+y
}

object Point extends App{
  def apply(x: Int, y: Int): Point = new Point(x, y)

  val p  = new Point(3,4)
  println(p)
}

