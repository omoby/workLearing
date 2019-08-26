package sunddenly

/**
  *
  * @ClassName Item
  * @Author zhangqx02
  * @Date 2019/8/20 22:35
  * @Description
  *
  *4. 定义一个抽象类ltem，加入方法price和description。Simpleltem是一个在构造器中给出价格和描述的物件。利用val可以重写def这个事实。Bundle是一个可以包含其他物件的物件。其价格是打包中所有物件的价格之和。同时提供一个将物件添加到打包当中的机制，以及一个合适的description方法
  */

abstract class Item {
  def price:Double
  def description:String

}

class SimpleItem(override val price:Double,override val description:String) extends Item {}

class Bundle() extends Item{
  val itemList = scala.collection.mutable.ArrayBuffer[Item]()
  def addItem(item:Item): Unit ={
    itemList += item
  }

  override def price: Double = {
    var pri:Double = 0
    itemList.foreach(item => pri = pri+item.price)
    pri
  }

  override def description: String = {
    var des = ""
    itemList.foreach(item=>des=des+item.description+" ")
    des
  }
}

object ItemTest{
  val bundle = new Bundle

  def main(args: Array[String]): Unit = {
    val priceArr = Array(2.5,100,3.5,40,32.5)
    val desArr = Array("铅笔","水杯","笔记本","火腿肠","鼠标")
    for (item <- 0  until priceArr.length){
      bundle.addItem(new SimpleItem(priceArr(item),desArr(item)))
    }
    println("购物篮信息如下：")
    bundle.itemList.foreach(item=>println("描述： "+item.description+" 价格： "+item.price))
    println("所购物品如下： "+bundle.description)
    println("本次购物合计："+bundle.price)
  }
}