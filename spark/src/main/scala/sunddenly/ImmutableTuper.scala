package sunddenly

import java.io.File
import java.util.Scanner

/**
  *
  * @ClassName ImmutableTuper
  * @Author zhangqx02
  * @Date 2019/8/17 15:38
  * @Description
  *
  *重复前一个练习，这次用不可变的映射
  */

object ImmutableTuper {
  def main(args: Array[String]): Unit = {
    val in = new Scanner(new File("D:\\MyFile\\workLearning\\test.txt"))
    var maps = Map[String,Int]()
    var key:String = null

    while (in.hasNext()){
      key = in.next()
      maps+=(key->(maps.getOrElse(key,0)+1))
    }
    maps.foreach(println)
  }

}
