package sunddenly

import java.io.File

/**
  *
  * @ClassName NuberDir
  * @Author zhangqx02
  * @Date 2019/8/26 15:34
  * @Description
  *
  *9. 编写Scala程序，盘点给定目录及其子目录中总共有多少以.class为扩展名的文件
  */

object NumDir extends App{
    val path = "."
    val dir = new File(path)
    def subdirs(dir:File):Iterator[File]={
      val children = dir.listFiles().filter(_.getName.endsWith("class"))
      children.toIterator ++ dir.listFiles().filter(_.isDirectory).toIterator.flatMap(subdirs _)
    }
  val iterator = subdirs(dir)
  while (iterator.hasNext){
    println(iterator.next())
  }
    val n = subdirs(dir).length
    println(n)
  }