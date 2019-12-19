package pointoffer

/**
  *
  * @ClassName P01
  * @Author zhangqx02
  * @Date 2019/12/9 17:02
  * @Description
  * 题目描述
  * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
  *
  */

class  P01 {
  /**
    * 暴力查找法
    * @param target
    * @param array
    * @return
    */
  def find(target:Int,array: Array[Array[Int]]) ={
    val arrLength = array.length
    for(i <- 0 until(arrLength)){
      for (j <- 0 until(array(i).length)){
        if (target == array(i)(j)){
          true;
        }
      }
    }
    false
  }


  def proFind(target:Int, array: Array[Array[Int]]):Boolean={
  true
  }

}
