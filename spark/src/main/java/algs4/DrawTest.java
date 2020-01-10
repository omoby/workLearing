package algs4;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @ClassName DrawTest
 * @Author zhangqx02
 * @Date 2019/12/20 10:06
 * @Description
 */

public class DrawTest {
    public static void main(String[] args){
//        drawMethodValue();
//        drawRandomValue();
        drawSortedRandomValue();
    }

    /**
     * 函数值
     */
    public static void drawMethodValue(){
        int N = 50;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N;i++){
            StdDraw.point(i,i);
            StdDraw.point(i,i * i);
            StdDraw.point(i,i * Math.log(i));
        }
    }

    /**
     * 随机数组
     */
    public static void drawRandomValue(){
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++){
            a[i] = StdRandom.random();
        }
        for (int i = 0; i < N; i++){
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.setPenColor(255,0,0);
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }

    /**
     * 一排序的随机数组
     */
    public static void drawSortedRandomValue(){
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++){
            a[i] = StdRandom.random();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++){
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.setPenColor(255,0,0);
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }

}
