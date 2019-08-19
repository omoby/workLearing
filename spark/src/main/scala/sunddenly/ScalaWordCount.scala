package sunddenly

import java.io.File
import java.util.Scanner

import scala.collection.mutable


/**
  *
  * @ClassName ScalaWordCount
  * @Author zhangqx02
  * @Date 2019/8/17 15:30
  * @Description
  *
  * 编写一段程序，从文件中读取单词。用一个可变映射来清点每一个单词出现的频率。读取这些单词的操作可以使用java.utiI.Scanner:
  *
  * val in=new java.util.Scanner(new java.io.File("myfile.txt"))
  *
  * while　　(in.hasNext()) 处理in .next()
  *
  * 最后，打印出所有单词和它们出现的次数
  */

object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val in = new Scanner(new File("D:\\MyFile\\workLearning\\test.txt"))
    val maps = new mutable.HashMap[String,Int]()
    var key:String = null
    while (in.hasNext()){
      key = in.next()
      maps(key) = maps.getOrElse(key,0)+1
    }
//    maps.foreach(map => println(map._1+" => "+map._2))
    maps.foreach(println)
  }


}
