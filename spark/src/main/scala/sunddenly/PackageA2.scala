package sunddenly

/**
  *
  * @ClassName PackageA2
  * @Author zhangqx02
  * @Date 2019/8/20 15:28
  * @Description
  *
  *
  */

package com{
  package horstmann{
    object PackageA1{
      def hi = println("I am A")
    }
    package impatient{
      object B extends App{
        def hi = com.horstmann.PackageA1.hi
        hi
      }
    }
  }
}
