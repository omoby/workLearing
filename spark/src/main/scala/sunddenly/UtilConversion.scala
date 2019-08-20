package sunddenly

import sunddenly.InchesToCentimeters.{GallonsToLiters, MilesToKilometers}

/**
  *
  * @ClassName UtilConversion
  * @Author zhangqx02
  * @Date 2019/8/20 11:26
  * @Description
  *前一个练习不是很面向对象。提供一个通用的超类UnitConversion并定义扩展该超类的InchesToCentimeters,GallonsToLiters和MilesToKilometers对象
  *
  */

abstract  class UtilConversion {
  def Converse(from:Double):Double
}

object InchesToCentimeters extends UtilConversion{
  private val i2c = 30.48

  override def Converse(inches: Double): Double = {
    inches * i2c
  }

  object GallonsToLiters extends UtilConversion{
    private  val g2l = 3.785311784

    override def Converse(gallons: Double): Double = {
      gallons * g2l
    }
  }

  object MilesToKilometers extends UtilConversion{
    private val m2k = 1.609344

    override def Converse(miles: Double): Double = {
      miles * m2k
    }
  }
}

object Test{
  def main (args: Array[String] ): Unit = {
    val inches = 10
    val gallons = 10
    val miles = 10

    println(inches +" 英尺= "+ InchesToCentimeters.Converse(inches) +" 厘米")
    println(gallons +" 加仑="+ GallonsToLiters.Converse(gallons) +" 升")
    println(miles +" 英里="+ MilesToKilometers.Converse(miles)+" 千米")
}
}

