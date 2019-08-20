package sunddenly

/**
  *
  * @ClassName RGB
  * @Author zhangqx02
  * @Date 2019/8/20 14:23
  * @Description
  *
  *8. 编写一个枚举，描述RGB立方体的8个角。ID使用颜色值(例如:红色是0xff0000)
  *
  * 描述：RGB如果分别用8位表示，红是0xff0000，绿是0x00ff00，蓝是0x0000ff。以此类推 ，8个顶点分别是(0,0,0) (0,0,1) (0,1,0) (0,1,1) (1,0,0) (1,0,1) (1,1,0) (1,1,1)
  */

object RGB  extends Enumeration with App {
  val RED = Value(0xff0000,"Red")
  val BLACK = Value(0x000000,"Black")
  val GREEN = Value(0x00ff00,"Green")
  val CYAN = Value(0x00ffff,"Cyan")
  val YELLOW = Value(0xffff00,"Yellow")
  val WHITE = Value(0xffffff,"White")
  val BLUE = Value(0x0000ff,"Blue")
  val MAGENTA = Value(0xff00ff,"Magenta")

}
