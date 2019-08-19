package sunddenly

/**
  *
  * @ClassName TuperTest1
  * @Author zhangqx02
  * @Date 2019/8/17 15:22
  * @Description
  *
  * 设置一个映射，其中包含你想要的一些装备，以及它们的价格。然后构建另一个映射，采用同一组键，但在价格上打9折
  */

object TuperTest1 {
  def main(args: Array[String]): Unit = {
    val map = Map("Computer"->3000,"Iphone"->5000,"Disk"->100)
    val fold = for ((k,v) <- map) yield (k,v * 0.9)
    fold.foreach(elem=>println(elem._1+" "+elem._2))
  }

}
