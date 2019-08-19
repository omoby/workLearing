package sunddenly

import java.util.Properties

/**
  *
  * @ClassName SystemProperties
  * @Author zhangqx02
  * @Date 2019/8/19 18:25
  * @Description
  *打印出所有Java系统属性的表格，类似这样：
  *
  * java.runtime.name　　　　　　　　　　　　　　　　　　　　 | Java (TM)　　SE Runtime Environment
  *
  * sun.boot.library.path　　　　　　　　　　　　　　　　　　　　　 | /home/apps/jdk1.6.0_21/jre/lib/i386
  *
  * java.vm.version 　　　　　　　　　　　　　　　　　　　　　　　 |17.0-b16
  *
  * java.vm.vendor　　　　　　　　　　　　　　　　 　　　　　　　  | Sun Microsystems Inc.
  *
  * java.vendor.url 　　　　　 　　　　　　　　　　　　　　　　　　 | http://java.sun*com/
  *
  * path.separator　　　　　　　　　　　　　　　　　　　　　　　　 |：
  *
  * java.vm.name　　　　　　　　　　　　　　　　　　　　　　　　  |　　Java HotSpot (TM)　　Server VM
  */

object SystemProperties {
  def main(args: Array[String]): Unit = {
    val properties:Properties = System.getProperties()
    val keys = properties.stringPropertyNames().iterator();
    while(keys.hasNext){
      println(keys.next())
    }

    }

}
