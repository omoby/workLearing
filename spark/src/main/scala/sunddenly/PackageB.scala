package sunddenly

/**
  *
  * @ClassName PackageB
  * @Author zhangqx02
  * @Date 2019/8/20 15:13
  * @Description
  *
  *1. 编写示例程序，展示为什么
  *
  * package com.horstmann.impatient
  *
  * 不同于
  *
  * package com
  *
  * package horstmann
  *
  * package impatient
  *
  * 描述: 区别是后者的上层包也可见，而串写的只有当前包范围可见
  */
package com{
  package horstmann{
    object A{
      def hi = println("I am A")
    }
    package impatient{
      object PackageB extends App {
        def hi = A.hi
        hi
      }
    }
  }
}
