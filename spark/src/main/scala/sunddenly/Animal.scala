package sunddenly

/**
  *
  * @ClassName Animal
  * @Author zhangqx02
  * @Date 2019/8/20 19:33
  * @Description
  *
  *3. 翻开你喜欢的Java或C++教科书，一定会找到用来讲解继承层级的示例，可能是员工、宠物、图形或类似的东西，用Scala来实现这个示例
  */

abstract class Animal {
  def run
}
class Cat extends Animal{
  override def run: Unit = println("I can run,miao")
}

class  Dog extends Animal{
  override def run: Unit = println("I can run,wang!")
}

object Animal{
  def main(args: Array[String]): Unit = {
    val cat = new Cat
    val dog = new Dog
    cat.run
    dog.run
  }
}
