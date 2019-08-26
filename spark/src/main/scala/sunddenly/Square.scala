//package sunddenly
//
//import java.awt.Rectangle
///**
//  *
//  * @ClassName Square
//  * @Author zhangqx02
//  * @Date 2019/8/20 23:10
//  * @Description
//  *
//  *
//  */
//
//class Square  extends Rectangle{
//  height = 0
//  width = 0
//  x = 0
//  y = 0
//
//  def this(p:java.awt.Point,w:Int){
//    this()
//    this.height = w
//    this.width = w
//    this.x = p.x
//    this.y = p.y
//  }
//  def this(width:Int){
//    this(new Point(0,0),width)
//  }
//}
//
//object SquareTest{
//  def main(args: Array[String]): Unit = {
//    val rect1 = new Square()
//    val rect2 = new Square(2)
//    val rect3 = new Square(new Point(2,3),5)
//    println(rect1)
//    println(rect2)
//    println(rect3)
//  }
//}
