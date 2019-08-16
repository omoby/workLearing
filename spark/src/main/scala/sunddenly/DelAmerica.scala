package sunddenly

/**
  *
  * @ClassName DelAmerica
  * @Author zhangqx02
  * @Date 2019/8/16 17:21
  * @Description
  *创建一个由Java.util.TimeZone.getAvailableIDs返回的时区集合，判断条件是它们在美洲。去掉"America/"前缀并排序
  *
  */

object DelAmerica {

  def main(args: Array[String]): Unit = {
    val array = timeZone()
    array.foreach(println)
  }

  def timeZone()={
    val timeZone = java.util.TimeZone.getAvailableIDs()
   val tmp =  for (elem <- timeZone if elem.startsWith("America/")) yield {
      elem.drop("America/".length)
    }
    scala.util.Sorting.quickSort(tmp)
    tmp
  }

}
