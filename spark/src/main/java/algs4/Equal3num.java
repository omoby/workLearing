package algs4;


/**
 * @ClassName Equal3num
 * @Author zhangqx02
 * @Date 2020/1/2 10:24
 * @Description
 */

public class Equal3num {
    public static void main(String[] args){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        test(num1,num2,num3);
    }

    private static void test(int num1, int num2, int num3) {
        if (num1 == num2 && num2 == num3){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
