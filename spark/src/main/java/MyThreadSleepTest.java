import java.util.Date;

/**
 * @ClassName MyThreadSleepTest
 * @Author zhangqx02
 * @Date 2019/8/15 17:49
 * @Description
 * 线程睡眠---sleep
 */

public class MyThreadSleepTest {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {

            System.out.println("当前时间: " + new Date());

            // 调用sleep方法让当前线程暂停1s。

            Thread.sleep(1000);

        }

    }

}