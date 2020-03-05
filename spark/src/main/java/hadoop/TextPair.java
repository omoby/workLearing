package hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName TextPair
 * @Author zhangqx02
 * @Date 2020/1/10 10:18
 * @Description
 * @==> 存储一对Text队形的Writable实现
 */

public class TextPair  implements WritableComparable<TextPair> {
    private Text first;
    private Text second;

    public TextPair() {
        set(new Text(),new Text());
    }

    public TextPair(String first, String second){
        set(new Text(first),new Text(second));
    }

    public TextPair(Text first,Text second){
        set(first, second);
    }

    public void set(Text first,Text second){
        this.first = first;
        this.second = second;
    }

    public Text getFirst() {
        return first;
    }

    public void setFirst(Text first) {
        this.first = first;
    }

    public Text getSecond() {
        return second;
    }

    public void setSecond(Text second) {
        this.second = second;
    }

    @Override
    public int compareTo(TextPair o) {
        int cmp = first.compareTo(o.first);
        if (cmp != 0){
            return cmp;
        }
        return second.compareTo(o.second);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        first.write(out);
        second.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first.readFields(in);
        second.readFields(in);
    }

    public int hasCode(){
        return first.hashCode() * 163 + second.hashCode();
    }

    public boolean equals(Object o){
        if (o instanceof TextPair){
            TextPair tp = (TextPair) o;
            return first.equals(tp.first) && second.equals(tp.second);
        }
        return false;
    }
    public String toString(){
        return first +"\t"+ second;
    }
}
