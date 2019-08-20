package sunddenly

/**
  *
  * @ClassName PokerFace
  * @Author zhangqx02
  * @Date 2019/8/20 14:09
  * @Description
  *
  * 编写一个扑克牌4种花色的枚举,让其toString方法分别返回♣,♦,♥,♠
  *
  * 描述：这四个花色的符号win下选输入法的特殊符号软键盘。在lin下可以用vim。在vim中输入:dig可以找到分别对应cS,cH,cD,cC。进入vim插入模式按<CTRL-K>，然后分别输入即可
  */

object PokerFace extends Enumeration {

  type PokerFace = Value

  val SPADES = Value("♠")
  val HEARTS = Value("♥")
  val DIAMONDS = Value("♦")
  val CLUBS = Value("♣")

  def main(args: Array[String]): Unit = {
    for(poker <- PokerFace.values){
      println(poker)
    }
  }

}
