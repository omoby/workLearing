package algs4;


import edu.princeton.cs.algs4.StdIn;

/**
 * @ClassName DoubleTest
 * @Author zhangqx02
 * @Date 2020/1/2 10:36
 * @Description
 */

public class DoubleTest {
    public static void main(String[] args){
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        boolean isX = check( x);
        boolean isY = check(y);
        if (isX && isY){
            System.out.println("true");
        }else {
            System.out.println("flase");
        }
    }

    private static boolean check(double num) {

        return (num > 0.0 && num < 1.0);

    }
}
