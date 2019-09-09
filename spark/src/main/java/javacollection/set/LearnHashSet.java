package javacollection.set;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName set
 * @Author zhangqx02
 * @Date 2019/9/9 14:03
 * @Description
 * 学习HashSet
 *
 *构造方法摘要
 *  * HashSet()
 *  *           构造一个新的空 set，其底层 HashMap 实例的默认初始容量是 16，加载因子是 0.75。
 *
 *  * HashSet(Collection<? extends E> c)
 *  *           构造一个包含指定 collection 中的元素的新 set。
 *
 *  * HashSet(int initialCapacity)
 *  *           构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和默认的加载因子（0.75）。
 *
 *  * HashSet(int initialCapacity, float loadFactor)
 *  *           构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和指定的加载因子。
 *
 *方法摘要
 *  *  boolean	add(E e)
 *  *           如果此 set 中尚未包含指定元素，则添加指定元素。
 *
 *  *  void	clear()
 *  *           从此 set 中移除所有元素。
 *
 *  *  Object	clone()
 *  *           返回此 HashSet 实例的浅表副本：并没有复制这些元素本身。
 *
 *  *  boolean	contains(Object o)
 *  *           如果此 set 包含指定元素，则返回 true。
 *
 *  *  boolean	isEmpty()
 *  *           如果此 set 不包含任何元素，则返回 true。
 *
 *  *  Iterator<E>	iterator()
 *  *           返回对此 set 中元素进行迭代的迭代器。
 *
 *  *  boolean	remove(Object o)
 *  *           如果指定元素存在于此 set 中，则将其移除。
 *
 *  *  int	size()
 *  *           返回此 set 中的元素的数量（set 的容量）。
 *
 *从类 java.util.AbstractSet 继承的方法
 *  * equals, hashCode, removeAll
 *
 *从类 java.util.AbstractCollection 继承的方法
 *  * addAll, containsAll, retainAll,toArray, toArray, toString
 *
 *从类 java.lang.Object 继承的方法
 *  * finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 *从接口 java.util.Set 继承的方法
 *  * addAll, containsAll, equals, hashCode, removeAll, retainAll, toArray, toArray
 */

public class LearnHashSet {
    public static void main(String[] args){
        Set hs = new HashSet();

        // 如果此 set 中尚未包含指定元素，则添加指定元素。
        hs.add(1);
        hs.add("Hadoop");
        hs.add("2");
        hs.add("Spark");

        //返回此 HashSet 实例的浅表副本：并没有复制这些元素本身。
        Set cloneSet = (Set)((HashSet) hs).clone();

        String hsString = hs.toString();
        System.out.println("hs to String: "+ hsString);

        //如果此 set 不包含任何元素，则返回 true。
        boolean isEmpty = hs.isEmpty();
        System.out.println("hs is empty: "+ isEmpty);

        //从此 set 中移除所有元素。
        hs.clear();
        System.out.println("Call clear(): "+ hs.toString());


        // 返回此 set 中的元素的数量（set 的容量）。
        int size = hs.size();
        System.out.println("hs size: "+ size);

        System.out.println("cloneSet to String: "+ cloneSet.toString());

        //如果此 set 包含指定元素，则返回 true。
        boolean isContains3 = cloneSet.contains(3);
        System.out.println("cloneSet contains 3: "+ isContains3);

        boolean isContainsSpark = cloneSet.contains("Spark");
        System.out.println("cloneSet contains Spark: "+ isContainsSpark);

        //返回对此 set 中元素进行迭代的迭代器。
        Iterator iterator = cloneSet.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("iterator: "+ next);
        }

        //如果指定元素存在于此 set 中，则将其移除,并返回true，否则返回false
        boolean is2 = cloneSet.remove(2);
        System.out.println("is2: "+ is2);
        boolean isString2 = cloneSet.remove("2");
        System.out.println("isString2: "+ isString2);
        System.out.println("cloneSet call remove(): "+ cloneSet.toString());
    }
}
