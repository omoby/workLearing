package test;


/**
 * @ClassName XMethodTest
 * @Author zhangqx02
 * @Date 2019/12/5 9:30
 * @Description
 */

public class XMethodTest {
    public static void main(String[] args){
        int x = 1;
        int y = 2;
        xMethod(x, y);
    }
    public static void xMethod(int x,int y){
        System.out.println(x+y);
//        return x+y;
    }
}
