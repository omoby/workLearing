package hadoop;

import org.apache.hadoop.io.Text;

import java.nio.ByteBuffer;

/**
 * @ClassName TextIterator
 * @Author zhangqx02
 * @Date 2020/1/10 9:48
 * @Description
 * @==> 遍历Text对象中的字符
 */

public class TextIterator {
    public static void main(String[] args){
        Text text = new Text("\u0042\u00DF\u6771\uD801\uDC00");
        ByteBuffer buf = ByteBuffer.wrap(text.getBytes(),0,text.getLength());
        int cp;
        while (buf.hasRemaining() && (cp = Text.bytesToCodePoint(buf)) != -1){
            System.out.println(Integer.toHexString(cp));
        }

        Text t = new Text("hadoop");
        t.set("pig");
        assert(t.getLength()==3);
    }
}
