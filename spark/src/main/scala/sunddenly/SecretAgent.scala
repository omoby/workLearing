package sunddenly

/**
  *
  * @ClassName SecretAgent
  * @Author zhangqx02
  * @Date 2019/8/20 23:23
  * @Description
  *
  *
  */

class Person ( val name: String ) {

  override def toString=getClass.getName+"name="+ name+ "]"

}

class SecretAgent (codename: String) extends Person (codename) {

  override val name = "secret" // 不想暴露真名…

  override val toString = "secret" // …或类名

}