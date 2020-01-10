package algs4;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName TestVisualAccumulator
 * @Author zhangqx02
 * @Date 2020/1/3 8:52
 * @Description
 */

public class TestVisualAccumulator {
    public static void main(String[] args){
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T,1.0);
        for (int i = 0; i < T; i++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
