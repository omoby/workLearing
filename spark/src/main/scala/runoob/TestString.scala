package runoob

/**
  *
  * @ClassName TestString
  * @Author zhangqx02
  * @Date 2019/8/14 9:06
  * @Description
  *
  *学习String
  */

object TestString {

  def main(args: Array[String]): Unit = {
    //创建字符串
    val greeting:String = "Hello,World"
    println(greeting)

    //创建可变字符串

    val buf = new StringBuilder
    buf += 'a'
    buf ++= "bcdf"
    println("StringBuff value = "+buf.toString())

    //字符串的长度
    val palindrome = "www.runoob.com"
    val len = palindrome.length
    println("String length is=" +len)

    //字符串拼接
    var str1 = "Hello"
    var str2  =" World"
    var str3 = "hello"
    var str4 = " scala"
    println("User + splice:"+str1+str2)
    println("User concat splice:"+str3.concat(str4))

    //创建格式化字符串

    var floatVar = 12.12121
    var intVar = 2000
    var stringvar = "Hello Scala"
    var fs = printf("float value = %f,int value = %d,string value = %s",floatVar,intVar,stringvar )

    println("Use printf() string = "+ fs)
  }

}
