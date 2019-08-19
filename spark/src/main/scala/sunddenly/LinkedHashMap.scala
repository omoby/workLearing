package sunddenly

import java.util.Calendar

import scala.collection.mutable

/**
  *
  * @ClassName LinkedHashMap
  * @Author zhangqx02
  * @Date 2019/8/19 18:17
  * @Description
  *
  *定义一个链式哈希映射，将＂Monday＂映射java.utiI.Calendar.MONDAY，依此类推加入其他日期。展示元素是以插入的顺序被访问的
  */

object LinkedHashMap {
  def main(args: Array[String]): Unit = {
    val map = new mutable.LinkedHashMap[String,Int]
    map += ("Monday"->Calendar.MONDAY)
    map += ("Tuesday"->Calendar.TUESDAY)
    map += ("Thursday"->Calendar.THURSDAY)
    map += ("Wednesday"->Calendar.WEDNESDAY)
    map +=("Friday" -> Calendar.FRIDAY)
    map += ("Saturday"->Calendar.SATURDAY)
    map += ("Sunday"->Calendar.SUNDAY)
    map.foreach(p => println(p._1+" "+ p._2))

    println("-------------")
    map.foreach(println)
  }

}
