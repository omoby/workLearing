package jvm.chapter1;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Author zhangqx02
 * @Date 2020/1/1 10:02
 * @Description
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
