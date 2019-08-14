package runoob

/**
  *
  * @ClassName TestExtractor
  * @Author zhangqx02
  * @Date 2019/8/14 17:56
  * @Description
  *
  *
  */

object TestExtractor {
  def main(args: Array[String]): Unit = {
    println("Apply方法： "+apply("Zara","gmail.com"))
    println("Unapply方法： "+ unapply("Zara@gmail.com"))
    println("Unapply方法： "+unapply("Zara Ali"))
  }
//注入方法（可选）
  def apply(user:String,domain:String) = {
    user +"@"+domain
  }

  def unapply(arg: String): Option[(String,String)] = {
    val parts = arg split "@"
    if (parts.length == 2){
      Some(parts(0),parts(1))
    }else{
      None
    }
  }

}
