package sunddenly

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @ClassName Person
  * @Author zhangqx02
  * @Date 2019/8/26 15:41
  * @Description
  *
  *10. 扩展那个可序列化的Person类，让它能以一个集合保存某个人的朋友信息。构造出一些Person对象，让他们中的一些人成为朋友，
  * 然后将Array[Person]保存到文件。将这个数组从文件中重新读出来，校验朋友关系是否完好 注意,请在main中执行。脚本执行无法序列化。
  */

class Persons(var name:String) extends Serializable{
  val friends = new ArrayBuffer[Persons]()
  def addFriend(friend : Persons){
    friends += friend
  }
  override def toString() = {
    var str = "My name is " + name + " and my friends name is "
    friends.foreach(str += _.name + ",")
    str
  }
}

object PersonTest extends App{
  val path = "D:\\MyFile\\workLearning\\spark\\src\\files\\"
  val p1 = new Persons("JackChen")
  val p2 = new Persons("Jhon·D")
  val p3 = new Persons("Sunday")
  p1.addFriend(p2)
  p1.addFriend(p3)
  println(p1)
  val out = new ObjectOutputStream(new FileOutputStream(path+"person.txt"))
  out.writeObject(p1)
  out.close()
  val in = new ObjectInputStream(new FileInputStream(path+"person.txt"))
  val p = in.readObject().asInstanceOf[Persons]
  println(p)
}