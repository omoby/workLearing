package sunddenly

/**
  *
  * @ClassName Reverse
  * @Author zhangqx02
  * @Date 2019/8/20 14:03
  * @Description
  *5. 编写一个Scala应用程序，使用App特质，以反序打印命令行参数，用空格隔开。举例来说，scala Reverse Hello World应该打印World Hello
  *
  */

object Reverse extends App {
  for (str <- args.reverse){
    print(str +" ")
  }
}
