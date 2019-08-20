package sunddenly

/**
  *
  * @ClassName JavaMap2
  * @Author zhangqx02
  * @Date 2019/8/20 17:13
  * @Description
  *
  *7. 在前一个练习中，将所有引入语句移动到尽可能小的作用域里
  *
  * 描述：import可以放到任何区域，直接放到对象结构体当中，也没有问题
  */

object JavaMap2 {
  import java.util.{HashMap=>JHashMap}
  import scala.collection.mutable.HashMap
  def transMapValues(javaMap:JHashMap[Any,Any]):HashMap[Any,Any]={
    val result=new HashMap[Any,Any]
    for(k <- javaMap.keySet().toArray()){
      result+=k->javaMap.get(k)
    }
    result
  }
  def main(args: Array[String]): Unit = {
    val jmap:JHashMap[Any,Any]=new JHashMap[Any,Any]
    var smap=new HashMap[Any,Any]
    for(i <- 1 to 10)
      jmap.put(i,"JavaMap"+i)
    smap=transMapValues(jmap)
    smap.foreach(println)
  }
}