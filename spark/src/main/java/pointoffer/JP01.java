package pointoffer;


/**
 * @ClassName JP01
 * @Author zhangqx02
 * @Date 2019/12/9 17:52
 * @Description
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class JP01 {
    public boolean find(int target,int[][] array){
        for (int i = 0; i < array.length;i++){
            for (int j = 0; j < array[i].length; j++){
                if (target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean proFind(int target, int[][] array){
        int rowLength =  array.length-1;
        int colLength = 0;
        boolean isContains = false;
        while(rowLength>=0 && !isContains){
            while (colLength <array[0].length){
                if (array[rowLength][colLength] == target){
                    isContains = true;
                    break;
                }else if (array[rowLength][colLength] > target){
                    rowLength--;
                }else{
                    colLength++;
                }
            }
        }
        return isContains;
    }
}
