package algs4;


import edu.princeton.cs.algs4.*;

/**
 * @ClassName Interval2D
 * @Author zhangqx02
 * @Date 2020/1/2 15:59
 * @Description
 * args: .2 .5 .5 .6 10000
 */

public class Interval2Ds {
    public static void main(String[] args){
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xinterval = new Interval1D(xlo,xhi);
        Interval1D yinterval = new Interval1D(ylo,yhi);
        Interval2D box = new Interval2D(xinterval,yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int t = 0; t < T;t++){
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x,y);
            if (box.contains(p)){
                c.increment();
            }else {
                p.draw();
            }
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}
