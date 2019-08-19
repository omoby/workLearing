package sunddenly

import java.io.File
import java.util
import java.util.Scanner

/**
  *
  * @ClassName TreeMapTuper
  * @Author zhangqx02
  * @Date 2019/8/17 15:50
  * @Description
  *重复前一个练习，这次用java.utiI.TreeMap并使之适用于Scala API
  *
  */

object TreeMapTuper{
  def main(args: Array[String]): Unit= {
    val in = new Scanner(new File("D:\\MyFile\\workLearning\\test.txt"))
    var map:util.TreeMap[String, Int] = new util.TreeMap[String,Int]()
    var key:String = null
    while(in.hasNext()){
      key=in.next()
      if (map.containsKey(key)){
        map.put(key,map.get(key)+1)
      }else{
        map.put(key,1)
      }
    }
  println(map.toString)
  }

//  def main(args: Array[String]): Unit = {
//    val in = new Scanner(new File("D:\\MyFile\\workLearning\\test.txt"))
//    var map:Map[String,Int] = new util.TreeMap[String,Int]()
//    var key:String = null
//
//    while (in.hasNext()){
//      key = in.next()
//      map(key) = map.getOrElse(key,0)+1
//    }
//  }

}