package sunddenly

import java.io.File
import java.util.Scanner

import scala.collection.SortedMap

/**
  *
  * @ClassName SortedTuper
  * @Author zhangqx02
  * @Date 2019/8/17 15:45
  * @Description
  *
  *重复前一个练习，这次用已排序的映射，以便单词可以按顺序打印出来
  */

object SortedTuper {
  def main(args: Array[String]): Unit = {
    val in = new Scanner(new File("D:\\MyFile\\workLearning\\test.txt"))

    var maps = SortedMap[String,Int]()
    var key:String = null

    while (in.hasNext()){
      key = in.next()
      maps += (key->(maps.getOrElse(key,0)+1))
    }
    maps.foreach(println)
  }

}
