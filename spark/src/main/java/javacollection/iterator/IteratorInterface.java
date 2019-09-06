package javacollection.iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IteratorInterface
 * @Author zhangqx02
 * @Date 2019/9/6 9:26
 * @Description
 *
 * 迭代器接口
 *  Iterator可以应用于所有的集合，Set、List和Map和这些集合的子类型
 *
 *  *方法摘要
 *  *boolean	hasNext()
 *  *如果仍有元素可以迭代，则返回 true。
 *  *
 *  *E	next()
 *  *返回迭代的下一个元素。
 *  *
 *  *void	remove()
 *  *从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。
 */

public class IteratorInterface {

    public static void main(String[] args){
        List<String> list  = new ArrayList<>();

        list.add("Java");
        list.add("is");
        list.add("a");
        list.add("very");
        list.add("useful");
        list.add("language");
        list.add("!");

        System.out.println("list: "+ list);

        Iterator<String> iterator = list.iterator();
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()){
            String str = iterator.next()+" ";
            sb.append(str);
        }

        System.out.println("sb: "+ sb.toString());
    }
}
