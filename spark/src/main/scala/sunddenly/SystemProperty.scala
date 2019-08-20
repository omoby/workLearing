package sunddenly

/**
  *
  * @ClassName SystemProperty
  * @Author zhangqx02
  * @Date 2019/8/20 17:14
  * @Description
  *
  *8. 以下代码的作用是什么，这是个好主意吗
  *
  * import java._
  *
  * import javax._
  *
  * 引入了java和javax的所有内容。因为Scala会自动覆盖java的同名类，不会有冲突。即使这样，引入过多的包，也会让人很迷惑。况且scala编译就已经够慢的了
  *
  * 9. 编写一段程序，引人java.lang.System类，从user.name系统属性读取用户名，从Console对象读取一个密码，如果密码不是" secret"，则在标准错误流中打印一个消息；如果密码是" secret"，则在标准输出流中打印一个问候消息。不要使用任其他引入，也不要使用任何限定词，即带句点的那种
  * 10. 除了StringBuilder，还有那些java.lang的成员是被scala包覆盖的
  *
  * Console,Math, 还有基本类型包装对象，Long,Double,Char,Short等等都被Scala覆盖了。
  */

object SystemProperty {
    import scala.io.StdIn
    import java.lang.System._
    def main(args: Array[String]): Unit = {

      val pass=StdIn.readLine()

      if(pass=="secret"){
        val name=getProperty("user.name")
        out.printf("Greetings,%s!",name)
      }else{
        err.println("error")
      }
    }
  }