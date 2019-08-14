
class Person{
	var name = ""
	override def toString = getClass.getName+"[name="+name+"]"
}

class Employee extends Person{
	var salary = 0
	override def toString = super.toString+"[salary="+salary+"]"

}


object TestAbstractClass{
	def main(args:Array[String]){
		val fred = new Employee
		fred.name = "Fred"
		fred.salary = 5000
		println(fred)
	}
}