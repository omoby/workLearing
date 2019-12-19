package test;


import java.util.Arrays;

/**
 * @ClassName ArrayTest
 * @Author zhangqx02
 * @Date 2019/12/19 15:50
 * @Description
 * 数组起别名
 */

public class ArrayTest {
    public  static void main(String[] args){
        int[] a = new int[2];
        a[0] = 0;
        a[1] = 1;
        int[] b = a;
        b[0]= 3;
        b[1] = 4;
        System.out.println("a； "+Arrays.toString(a));
        System.out.println("b: "+Arrays.toString(b));
    }
}
