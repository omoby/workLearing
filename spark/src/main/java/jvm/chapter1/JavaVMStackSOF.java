package jvm.chapter1;


/**
 * @ClassName JavaVMStackSOF
 * @Author zhangqx02
 * @Date 2020/1/1 14:14
 * @Description
 * VM Args：-Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}