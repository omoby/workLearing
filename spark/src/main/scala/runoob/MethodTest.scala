package runoob

object MethodTest {
  def main(args: Array[String]): Unit = {
    println("Returned Value : "+ addInt(5,7))
  }

  def addInt(a:Int,b:Int):Int={
      var sumInt:Int = 0
      sumInt = a + b
      sumInt

  }
}
