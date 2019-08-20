package sunddenly

/**
  *
  * @ClassName Conversions
  * @Author zhangqx02
  * @Date 2019/8/20 10:42
  * @Description
  *编写一个Conversions对象，加入inchesToCentimeters,gallonsToLiters和milesToKilometers方法
  *
  */

object Conversions {
  private val i2c = 30.48 //1 inches = 30.48 centimeters
  private val g2l = 3.785411784 //1 gallon = 3.785411784 liters
  private val m2k = 1.609344 //1 mile = 1.609344 kilometers

  /**
    * 英尺转换为厘米
    * @param inches 英尺
    * @return
    */
  def inchesToCentimeters(inches:Double):Double={
    inches * i2c
  }

  /**
    * 加仑转换为升
    * @param gallon 加仑
    * @return
    */
  def gallonsToLiters(gallon:Double):Double={
    gallon * g2l
  }

  /**
    * 英里转化为千米
    * @param miles 英里
    * @return
    */
  def milesToKilometers(miles:Double):Double={
    miles * m2k
  }

  def main(args: Array[String]): Unit = {
    val inches = 15
    val gallon = 15
    val miles = 15

    println(inches+ " 英寸="+inchesToCentimeters(inches)+" 厘米")
    println(gallon +" 加仑="+gallonsToLiters(gallon)+" 升")
    println(miles+ " 英里="+milesToKilometers(miles)+" 千米")
  }

}
