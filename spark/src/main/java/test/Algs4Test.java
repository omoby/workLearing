package test;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.codehaus.jackson.map.BeanProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Algs4Test
 * @Author zhangqx02
 * @Date 2019/12/20 13:40
 * @Description
 */

public class Algs4Test {

    public static void main(String[] args){
//        test1();
//        test2( -2147483648);
//        test3();
//        test4();
        test5();
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        printArr(arr);
        test6(arr);
    }
    private static void test1(){
        double num = 2.0e-6 * 1000000000.1;
        System.out.println(num);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1+2+"3");
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        System.out.println((1+2.236) /2);
    }
    private static void  test2(int num){
        int newNum = Math.abs(num);
        System.out.println(newNum);
    }

    private static void test3(){
        int f = 0;
        int g = 1;
        for(int i=0;i<=15;i++){
            StdOut.println(f);
            f=f+g;
            g=f-g;
        }
    }
    private static void test4(){
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for(int j=0;j<i;j++)
                sum++;
        StdOut.println(sum);

         sum = 0;
        for(int i =1;i<1000;i*=2)
            for(int j=0;j<1000;j++)
                sum++;
        StdOut.println(sum) ;

        String s = "";
        for(int n = 125; n > 0; n /=2)
            s = (n%2)+ s;
        StdOut.println(s);
    }

    private static void test5(){
        boolean[][] arr = new boolean[10][10];
        initArray(arr);
        printTest(arr);
    }

    private static void initArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (StdRandom.bernoulli()){
                    arr[i][j] = true;
                }else {
                    arr[i][j] = false;
                }
            }
        }
    }
    private static void printTest(boolean[][] arr){
        StdOut.print(" ");
        for (int i = 0; i < arr[0].length; i++){
            StdOut.print(" "+i);
        }
        StdOut.println(" ");

        for (int j = 0; j < arr.length; j++){
            StdOut.print(j+" ");
            for (int k = 0; k < arr[j].length; k++){
                if (arr[j][k]){
                    StdOut.print("*"+ " ");
                }else {
                    StdOut.print("-"+" ");
                }
            }
            StdOut.println();

        }

    }

    private static void test6(int[][] arr){
        int[][] arrb = new int[arr[0].length][arr.length];
        printArr(arr);
        for (int i= 0;i < arr.length;i++){
            for (int j = 0; j < arr[i].length; j++){
                arrb[j][i] = arr[i][j];
            }
        }
        printArr(arrb);
    }
    private static void printArr(int[][] arr){
        StdOut.print(" ");
        for (int i = 0; i < arr[0].length; i++){
            StdOut.print(" "+i);
        }
        StdOut.println(" ");

        for (int j = 0; j < arr.length; j++){
            StdOut.print(j+" ");
            for (int k = 0; k < arr[j].length; k++){
               StdOut.print(arr[j][k]+" ");
            }
            StdOut.println();

        }

    }
}
