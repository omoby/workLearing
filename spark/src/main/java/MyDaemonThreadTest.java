/**
 * @ClassName MyDaemonThreadTest
 * @Author zhangqx02
 * @Date 2019/8/15 17:41
 * @Description
 */

public class MyDaemonThreadTest extends Thread {
    // 定义后台线程的线程执行体与普通线程没有任何区别
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "" + i);
        }
    }

    public static void main(String[] args) {
        MyDaemonThreadTest t = new MyDaemonThreadTest();
        // 将此线程设置成后台线程
        t.setDaemon(true);
        // 启动后台线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("MyDaemonThreadTest: "+t.isDaemon());
            System.out.println("main: "+Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName() + "" + i);
        }
        // -----程序执行到此处，前台线程（main线程）结束------
        // 后台线程也应该随之结束
    }
}