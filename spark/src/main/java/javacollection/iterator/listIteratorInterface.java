package javacollection.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName listIteratorInterface
 * @Author zhangqx02
 * @Date 2019/9/6 9:26
 * @Description
 * 迭代器接口
 * ListIterator只能用于List及其子类型。
 *
 * * void	add(E e)
 * * 将指定的元素插入列表（可选操作）。
 * * boolean	hasNext()
 * * 以正向遍历列表时，如果列表迭代器有多个元素，则返回 true（换句话说，如果 next 返回一个元素而不是抛出异常，则返回 true）。
 * * boolean	hasPrevious()
 * * 如果以逆向遍历列表，列表迭代器有多个元素，则返回 true。
 * * E	next()
 * * 返回列表中的下一个元素。
 * * int	nextIndex()
 * * 返回对 next 的后续调用所返回元素的索引。
 * * E	previous()
 * * 返回列表中的前一个元素。
 * * int	previousIndex()
 * * 返回对 previous 的后续调用所返回元素的索引。
 * * void	remove()
 * * 从列表中移除由 next 或 previous 返回的最后一个元素（可选操作）。
 * * void	set(E e)
 * * 用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）。
 */

public class listIteratorInterface {
    public static void main(String[] args){
        List<String> list = new LinkedList<>();


        list.add("Java");
        list.add("is");
        list.add("a");
        list.add("very");
        list.add("useful");
        list.add("language");
        list.add("!");

        System.out.println("Before list: "+ list);

        ListIterator iterator = list.listIterator();

        System.out.println("Next: ");
        //以正向遍历列表时，如果列表迭代器有多个元素，则返回 true（换句话说，如果 next 返回一个元素而不是抛出异常，则返回 true）
        while (iterator.hasNext()){
            //返回对 next 的后续调用所返回元素的索引
            int index = iterator.nextIndex();
            //返回列表中的下一个元素
            String str = String.valueOf(iterator.next());
            if ("！".equals(str)){
                break;
            }else{
                System.out.println(str + " " + index);
            }


        }
        System.out.println();

        System.out.println("Previous: ");
        //果以逆向遍历列表，列表迭代器有多个元素，则返回 true。
        while (iterator.hasPrevious()){
            //返回对 previous 的后续调用所返回元素的索引。
            int index = iterator.previousIndex();
            //返回列表中的前一个元素。
            String str = String.valueOf(iterator.previous());

            if ("is".equals(str)){
                //用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）
                 iterator.set("IS");
            }
            System.out.println(str + " " +index);
        }
        System.out.println();

        //从列表中移除由 next 或 previous 返回的最后一个元素（可选操作）
        iterator.remove();
        System.out.println("list: "+list);

        //将指定的元素插入列表（可选操作）
        iterator.add("java");
        System.out.println("list: "+list);


    }

}
