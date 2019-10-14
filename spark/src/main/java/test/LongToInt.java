package test;


/**
 * @ClassName LongToInt
 * @Author zhangqx02
 * @Date 2019/9/23 13:59
 * @Description
 */

public class LongToInt {
    public static void main(String[] args){
        Object obj = 10L;
        int b = ((Long)obj).intValue();
        System.out.println(b);
        System.out.println(String.valueOf(obj));

    }
}
