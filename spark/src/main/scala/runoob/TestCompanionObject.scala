package runoob

/**
  *
  * @ClassName TestCompanionObject
  * @Author zhangqx02
  * @Date 2019/8/14 15:54
  * @Description
  *
  *
  */

class TestCompanionObject private(val color:String) {
  println("创建"+this)
  override def toString():String = "颜色标记："+color
}

object TestCompanionObject{
  private val testCompanionObject:Map[String,TestCompanionObject] = Map(
    "red"->new TestCompanionObject("red"),
  "blue"->new TestCompanionObject("blue"),
    "green"->new TestCompanionObject("green")
  )

  def apply(color:String)={
    if (testCompanionObject.contains(color)) testCompanionObject(color)
    else
      null
  }

  def getTestCompanionObject(color:String) ={
    if (testCompanionObject.contains(color))
      testCompanionObject(color)
    else
      null
  }

  def main(args: Array[String]): Unit = {
    println(TestCompanionObject("red"))

    println(TestCompanionObject getTestCompanionObject "blue")
  }
}
