package runoob

/**
  *
  * @ClassName ClassAndObject
  * @Author zhangqx02
  * @Date 2019/8/14 14:52
  * @Description
  *学习类和对象
  *
  */

/**
  * 点类
  * @param xc
  * @param yc
  */
class Point(xc:Int,yc:Int){
  var x:Int = xc
  var y:Int = yc

  def move(dx:Int,dy:Int): Unit ={
    x = x + dx
    y = y + dy
    println("x的坐标为："+x)
    println("y的坐标为："+y)
  }
}

/**
  * 继承Point类
  * @param xc
  * @param yc
  * @param zc
  */
class Location(val xc:Int,val yc:Int,val zc:Int) extends Point(xc,yc){
  var z:Int = zc
  def move(dx:Int,dy:Int,dz:Int): Unit ={
    x = x +dx
    y = y + dy
    z = z + dz

    println("x的坐标为："+x)
    println("y的坐标为："+y)
    println("z的坐标为："+z)

  }
}

object TestClassAndObject {

  def main(args: Array[String]): Unit = {
    println("点")
    val pt = new Point(1,2)
    pt.move(10,10)

    println("位置")

    val location = new Location(1,2,3)
    location.move(10,10,10)
  }

}
