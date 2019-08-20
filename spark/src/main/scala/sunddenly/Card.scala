package sunddenly

/**
  *
  * @ClassName Card
  * @Author zhangqx02
  * @Date 2019/8/20 14:16
  * @Description
  *
  *7. 实现一个函数，检查某张牌的花色是否为红色
  */

object Card extends Enumeration with App{

  val SPADES = Value("?")
  val HEARTS = Value("?")
  val DIAMONDS = Value("?")
  val CLUBS = Value("?")

  type Card = Value

  def color(c:Card): Unit ={
    if (c == Card.HEARTS || c == Card.DIAMONDS)
      println("Red")
    else
      println("Black")
  }
  color(SPADES)
  color(HEARTS)

}
