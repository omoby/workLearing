package runoob

/**
  *
  * @ClassName TestCaseClass
  * @Author zhangqx02
  * @Date 2019/8/14 17:09
  * @Description
  *
  * 样例类
  * 使用了case关键字的类定义就是就是样例类(case classes)，样例类是种特殊的类，经过优化以用于模式匹配
  */

object TestCaseClass {
  case class Person(name:String,age:Int)

  def main(args: Array[String]): Unit = {
    val alice = new Person("Alice",23)
    val bob = new Person("Bob",34)
    val charlie = new Person("Charlie",24)

    for( person <- List(alice,bob,charlie)){
      person match {
        case Person("Alice",23)=>println("Hi Alice")
        case Person("Bob",34) => println("Hi Bob!")
        case Person(name,age) =>
          println("Age: "+ age +" year,name: "+ name +"?")
      }
    }
  }

}
