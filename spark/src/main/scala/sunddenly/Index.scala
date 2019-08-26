package sunddenly

import java.io.PrintWriter

/**
  *
  * @ClassName Index
  * @Author zhangqx02
  * @Date 2019/8/26 14:49
  * @Description
  *
  *5. 编写Scala程序，向文件中写入2的n次方及其倒数，指数n从0到20。对齐各列:
  *
  * 1 1
  *
  * 2 0.5
  *
  * 4 0.25
  */

object Index  extends App{
  val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
  val fileName = "index"
  val fileDir = path+fileName+".txt"
  val out = new PrintWriter(fileDir)
  for(i <- 0 to 20){
    out.println(outIndex(i))
  }

  out.close()


  def outIndex(n:Int)={
    val value = math.pow(2,n)
    " "*4 +value.toInt+" "*(11-value.toString().size)+math.pow(2,-n)
  }


}
