package runoob

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  *
  * @ClassName TestException
  * @Author zhangqx02
  * @Date 2019/8/14 17:45
  * @Description
  *
  *
  */

object TestException {
  def main(args: Array[String]): Unit = {
    try{
      val f = new FileReader("input.txt")
    }catch{
      case ex:FileNotFoundException =>{
        println("Missing file Exception")
      }
      case ex:IOException=>{
        println("IO Exception")
      }
    }finally {
      println("Exiting finally ...")
    }
  }

}
