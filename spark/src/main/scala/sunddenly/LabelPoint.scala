package sunddenly

/**
  *
  * @ClassName LabelPoint
  * @Author zhangqx02
  * @Date 2019/8/20 22:58
  * @Description
  *
  *5. 设计一个Point类，其x和y坐标可以通过构造器提供。提供一个子类LabeledPoint，其构造器接受一个标签值和x、y坐标，比如：
  *
  * new LabeledPoint("Black Thursday", 1929, 230.07)
  */

class Points(val x:Double, val y:Double){
  override def toString: String = "x= "+x+" y= "+y
}
class LabelPoint(val label:String,override val x:Double,override val y:Double)  extends Points(x,y) {
  override def toString: String = "label= "+ label +"x= "+x+"y= "+y
}
object PointTest{
  def main(args: Array[String]): Unit = {
    val point = new Points(2,3)
    val labelPoint = new LabelPoint("圆形",2,3)

    println(point)
    println(labelPoint)
  }
}
