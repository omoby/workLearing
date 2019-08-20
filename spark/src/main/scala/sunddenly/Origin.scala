package sunddenly

/**
  *
  * @ClassName Origin
  * @Author zhangqx02
  * @Date 2019/8/20 13:54
  * @Description
  *
  *3. 定义一个扩展自java.awt.Point的Origin对象。为什么说这实际上不是个好主意 (仔细看Point类的方法)
  *
  * 描述：Point中的getLocation方法返回的是Point对象，如果想返回Origin对象，需要Origin类才行。Point有move方法，setLocation方法。这些作为Origin(原 点) 来说，都不是很合适
  */

object Origin extends java.awt.Point with App {
  override def getLocation: java.awt.Point = super.getLocation
  Origin.move(2,3)
  println(Origin.toString)

}
