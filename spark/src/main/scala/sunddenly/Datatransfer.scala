package sunddenly

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

/**
  *
  * @ClassName Datatransfer
  * @Author zhangqx02
  * @Date 2019/8/16 17:53
  * @Description
  *
  *引入java.awt.datatransfer._并构建一个类型为SystemFlavorMap类型的对象
  */

object Datatransfer {
  def main(args: Array[String]): Unit = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    println(flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer.mkString(" | "))
  }

}
