package javacollection.list;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * @ClassName LearnArrayList
 * @Author zhangqx02
 * @Date 2019/9/11 11:58
 * @Description
 *
 *从类 java.util.AbstractList 继承的字段
 *  * modCount
 *
 *构造方法摘要
 *  * ArrayList()
 *  *           构造一个初始容量为 10 的空列表。
 *  * ArrayList(Collection<? extends E> c)
 *  *           构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
 *  * ArrayList(int initialCapacity)
 *  *           构造一个具有指定初始容量的空列表。
 *
 *方法摘要
 *  *  boolean	add(E e)
 *  *           将指定的元素添加到此列表的尾部。
 *  *  void	add(int index, E element)
 *  *           将指定的元素插入此列表中的指定位置。
 *  *  boolean	addAll(Collection<? extends E> c)
 *  *           按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
 *  *  boolean	addAll(int index, Collection<? extends E> c)
 *  *           从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
 *  *  void	clear()
 *  *           移除此列表中的所有元素。
 *  *  Object	clone()
 *  *           返回此 ArrayList 实例的浅表副本。
 *  *  boolean	contains(Object o)
 *  *           如果此列表中包含指定的元素，则返回 true。
 *  *  void	ensureCapacity(int minCapacity)
 *  *           如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
 *  *  E	get(int index)
 *  *           返回此列表中指定位置上的元素。
 *  *  int	indexOf(Object o)
 *  *           返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
 *  *  boolean	isEmpty()
 *  *           如果此列表中没有元素，则返回 true
 *  *  int	lastIndexOf(Object o)
 *  *           返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1。
 *  *  E	remove(int index)
 *  *           移除此列表中指定位置上的元素。
 *  *  boolean	remove(Object o)
 *  *           移除此列表中首次出现的指定元素（如果存在）。
 *  * protected  void	removeRange(int fromIndex, int toIndex)
 *  *           移除列表中索引在 fromIndex（包括）和 toIndex（不包括）之间的所有元素。
 *  *  E	set(int index, E element)
 *  *           用指定的元素替代此列表中指定位置上的元素。
 *  *  int	size()
 *  *           返回此列表中的元素数。
 *  *  Object[]	toArray()
 *  *           按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组。
 *  * <T> T[]	toArray(T[] a)
 *  *           按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组；返回数组的运行时类型是指定数组的运行时类型。
 *  *  void	trimToSize()
 *  *           将此 ArrayList 实例的容量调整为列表的当前大小。
 *
 *从类 java.util.AbstractList 继承的方法
 *  * equals, hashCode, iterator, listIterator, listIterator, subList
 *
 *从类 java.util.AbstractCollection 继承的方法
 *  * containsAll, removeAll, retainAll, toString
 *
 *从类 java.lang.Object 继承的方法
 *  * finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 *从接口 java.util.List 继承的方法
 *  * containsAll, equals, hashCode, iterator, listIterator, listIterator, removeAll, retainAll, subList
 */


public class LearnArrayList {
    public static void main(String[] args){

        //构造一个初始容量为 10 的空列表。
        ArrayList list = new ArrayList<>();

        //将指定的元素添加到此列表的尾部。
        list.add("Hadoop");
        list.add("Spark");
        System.out.println("list: "+ list.toString());

        String[] soft = {"Hvie","Hbase"};
        //构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
        ArrayList list1 = new ArrayList(Arrays.asList(soft));
        System.out.println("list1: "+ list1.toString());

        //按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部。
        list.addAll(list1);
        System.out.println("call addAll(collection): "+ list.toString());

        //将指定的元素插入此列表中的指定位置。
        list.add(0,"Flink");
        System.out.println("call list(index,object): "+ list.toString());

        String[] soft1 = {"Java","Scala"};
        //从指定的位置开始，将指定 collection 中的所有元素插入到此列表中。
        list.addAll(0,Arrays.asList(soft1));
        System.out.println("call addAll(index,collection): "+ list.toString());

        //移除此列表中的所有元素。
        list1.clear();
        System.out.println("list1 call clear: "+ list1.toString());

        //如果此列表中没有元素，则返回 true
        boolean isEmpty = list1.isEmpty();
        System.out.println("list1 is empty: "+ isEmpty);

        //返回此 ArrayList 实例的浅表副本。
        list1 = (ArrayList) list.clone();
        System.out.println("call clone(): "+ list1.toString());

        String result = "";
        for(int i = 0 ; i < list.size();i++){
            //返回此列表中指定位置上的元素。
            result += ","+list.get(i);
        }
        System.out.println("call get(index): "+ result.substring(1));

        //返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
        int indexOfHadoop = list.indexOf("Hadoop");
        System.out.println("indexOfHadoop: "+ indexOfHadoop);

        //返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1。
        int lastIndexOfHadoop = list.lastIndexOf("Hadoop");
        System.out.println("lastIndexOfHadoop: "+ lastIndexOfHadoop);

        //移除此列表中指定位置上的元素。
        list.remove(0);
        System.out.println("call remove: "+ list.toString());

        //移除此列表中首次出现的指定元素（如果存在）。
        boolean remove1 = list1.remove("hadoop");
        System.out.println("remove hadoop: "+ remove1);

        boolean remove2 = list.remove("Hadoop");
        System.out.println("remove Hadoop: "+ remove2);
        System.out.println("list: "+ list.toString());

        //移除列表中索引在 fromIndex（包括）和 toIndex（不包括）之间的所有元素。
//        list.removeRange(1,3);
        System.out.println("list: "+ list);
        //用指定的元素替代此列表中指定位置上的元素。
        list.set(0,"C++");
        System.out.println("list: "+ list.toString());

        //按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组。
        Object[] arr = list.toArray();
        for(Object obj: arr){
            String value = obj.toString();
            System.out.println(value);
        }
        //按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组；返回数组的运行时类型是指定数组的运行时类型。
        String[] arr1 = (String[]) list.toArray(new String[0]);
        for (String str: arr1){
            System.out.println(str);
        }

        //返回此列表中的元素数。
        int size = list.size();
        System.out.println("size: "+ size);

        // 将此 ArrayList 实例的容量调整为列表的当前大小。
        list.trimToSize();
        int size1 = list.size();
        System.out.println("call trimToSize,size: "+ size1);


    }
    /**
     *
     */
}
