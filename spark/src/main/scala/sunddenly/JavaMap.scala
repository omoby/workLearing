package sunddenly

/**
  *
  * @ClassName JavaMap
  * @Author zhangqx02
  * @Date 2019/8/20 16:14
  * @Description
  *4. 在你看来，Scala的设计者为什么要提供package object法而不是简单地让你将函数和变量添加到包中呢
  *
  * 直接加函数和变量声明到包中，比如com.a.b.c。这样就跟c下面的的class或者object差 了一个层级。他们实际上是c下面的所有类的共同的上级定义。这样一来就没有了封装性。 而实现上来说估计也比较麻烦。
  *
  * 5. private[com] def giveRaise(rate: Double)的含义是什么，有用吗
  *
  * 该函数在com包下可见，可以扩大函数的可见范围
  *
  * 6. 编写一段程序，将Java哈希映射中的所有元素拷贝到Scala哈希映射。用引入语句重命名这两个类
  *
  */

import java.util.{HashMap => JHashMap}

import scala.collection.mutable
import scala.collection.mutable.HashMap
object JavaMap {
  def transMapValues(javaMap:JHashMap[Any,Any]):HashMap[Any,Any]={
    val result = new HashMap[Any,Any]
    for(k <- javaMap.keySet().toArray()){
      result += k->javaMap.get(k)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val jMap:JHashMap[Any,Any] = new JHashMap[Any,Any]()
    var smap = new mutable.HashMap[Any,Any]()
    for(i <- 1 to 9){
      jMap.put(i,"JavaMap"+i)
    }
    smap = transMapValues(jMap)
    smap.foreach(println)
  }


}
