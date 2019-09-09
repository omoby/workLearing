package javacollection.set;


import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.*;

/**
 * @ClassName LearnTreeMap
 * @Author zhangqx02
 * @Date 2019/9/9 15:32
 * @Description
 * 学习TreeMap
 *构造方法摘要
 *      * TreeSet()
 *      *           构造一个新的空 set，该 set 根据其元素的自然顺序进行排序。
 *
 *      * TreeSet(Collection<? extends E> c)
 *      *           构造一个包含指定 collection 元素的新 TreeSet，它按照其元素的自然顺序进行排序。
 *
 *      * TreeSet(Comparator<? super E> comparator)
 *      *           构造一个新的空 TreeSet，它根据指定比较器进行排序。
 *
 *      * TreeSet(SortedSet<E> s)
 *      *           构造一个与指定有序 set 具有相同映射关系和相同排序的新 TreeSet。
 *
 *方法摘要
 *      *  boolean	add(E e)
 *      *           将指定的元素添加到此 set（如果该元素尚未存在于 set 中）。
 *
 *      *  boolean	addAll(Collection<? extends E> c)
 *      *           将指定 collection 中的所有元素添加到此 set 中。
 *
 *      *  E	ceiling(E e)
 *      *           返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。
 *
 *      *  void	clear()
 *      *           移除此 set 中的所有元素。
 *
 *      *  Object	clone()
 *      *           返回 TreeSet 实例的浅表副本。
 *
 *      *  Comparator<? super E>	comparator()
 *      *           返回对此 set 中的元素进行排序的比较器；如果此 set 使用其元素的自然顺序，则返回 null。
 *
 *      *  boolean	contains(Object o)
 *      *           如果此 set 包含指定的元素，则返回 true。
 *
 *      *  Iterator<E>	descendingIterator()
 *      *           返回在此 set 元素上按降序进行迭代的迭代器。
 *
 *      *  NavigableSet<E>	descendingSet()
 *      *           返回此 set 中所包含元素的逆序视图。
 *
 *      *  E	first()
 *      *           返回此 set 中当前第一个（最低）元素。
 *
 *      *  E	floor(E e)
 *      *           返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
 *
 *      *  SortedSet<E>	headSet(E toElement)
 *      *           返回此 set 的部分视图，其元素严格小于 toElement。
 *
 *      *  NavigableSet<E>	headSet(E toElement, boolean inclusive)
 *      *           返回此 set 的部分视图，其元素小于（或等于，如果 inclusive 为 true）toElement。
 *
 *      *  E	higher(E e)
 *      *           返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。
 *
 *      *  boolean	isEmpty()
 *      *           如果此 set 不包含任何元素，则返回 true。
 *
 *      *  Iterator<E>	iterator()
 *      *           返回在此 set 中的元素上按升序进行迭代的迭代器。
 *
 *      *  E	last()
 *      *           返回此 set 中当前最后一个（最高）元素。
 *
 *      *  E	lower(E e)
 *      *           返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。
 *
 *      *  E	pollFirst()
 *      *           获取并移除第一个（最低）元素；如果此 set 为空，则返回 null。
 *
 *      *  E	pollLast()
 *      *           获取并移除最后一个（最高）元素；如果此 set 为空，则返回 null。
 *
 *      *  boolean	remove(Object o)
 *      *           将指定的元素从 set 中移除（如果该元素存在于此 set 中）。
 *
 *      *  int	size()
 *      *           返回 set 中的元素数（set 的容量）。
 *
 *      *  NavigableSet<E>	subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
 *      *           返回此 set 的部分视图，其元素范围从 fromElement 到 toElement。
 *
 *      *  SortedSet<E>	subSet(E fromElement, E toElement)
 *      *           返回此 set 的部分视图，其元素从 fromElement（包括）到 toElement（不包括）。
 *
 *      *  SortedSet<E>	tailSet(E fromElement)
 *      *           返回此 set 的部分视图，其元素大于等于 fromElement。
 *
 *      *  NavigableSet<E>	tailSet(E fromElement, boolean inclusive)
 *      *           返回此 set 的部分视图，其元素大于（或等于，如果 inclusive 为 true）fromElement。
 *
 *从类 java.util.AbstractSet 继承的方法
 *      * equals, hashCode, removeAll
 *
 *从类 java.util.AbstractCollection 继承的方法
 *      * containsAll, retainAll, toArray, toArray, toString
 *
 *从类 java.lang.Object 继承的方法
 *      * finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 *从接口 java.util.Set 继承的方法
 *      * containsAll, equals, hashCode, removeAll, retainAll, toArray, toArray
 *
 *
 */

public class LearnTreeSet{
    public static void main(String[] args){
        String[] softWare = {"Hadoop","Spark","Hive","Hbase"};
        Set treeSet = new TreeSet();

        // 将指定的元素添加到此 set（如果该元素尚未存在于 set 中）。
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("100");
        treeSet.add("30");

        treeSet.add("Hello");
        treeSet.add("Java");

        //将指定 collection 中的所有元素添加到此 set 中。
        treeSet.addAll(Arrays.asList(softWare));

        System.out.println("treeSet: "+treeSet.toString());


        //返回对此 set 中的元素进行排序的比较器；如果此 set 使用其元素的自然顺序，则返回 null。
        Comparable comparable = (Comparable) ((TreeSet) treeSet).comparator();
        System.out.println("comparable: "+ comparable);


        //如果此 set 包含指定的元素，则返回 true。
        boolean iscontains = treeSet.contains("Hello");
        System.out.println("treeSet contains Hello: "+ iscontains);

        // 返回在此 set 元素上按降序进行迭代的迭代器。
        Iterator descIterator = ((TreeSet) treeSet).descendingIterator();
        String string = "";
        while (descIterator.hasNext()){
            String next = String.valueOf(descIterator.next());
            string = string+" "+next;

        }
        System.out.println("descIterator: "+ string);


        //返回此 set 中所包含元素的逆序视图。
        NavigableSet set = ((TreeSet) treeSet).descendingSet();
        System.out.println("set: "+ set.toString());

        // 返回此 set 中当前第一个（最低）元素。
        Object first = ((TreeSet) treeSet).first();
        System.out.println("first: "+ first);

        //返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null
        Object floor = ((TreeSet) treeSet).floor("H");
        System.out.println("floor: "+ floor);

        //返回此 set 的部分视图，其元素严格小于 toElement。
        SortedSet sortedSet = ((TreeSet) treeSet).headSet("S");
        System.out.println("sortedSet: "+ sortedSet.toString() );

        //返回此 set 的部分视图，其元素小于（或等于，如果 inclusive 为 true）toElement。
        NavigableSet navigableSet = ((TreeSet) treeSet).headSet("Java", true);
        System.out.println("navigableSet: "+ navigableSet.toString());
        //返回此 set 的部分视图，其元素小于（或等于，如果 inclusive 为 true）toElement。
        NavigableSet navigableSetFlase = ((TreeSet) treeSet).headSet("Java", false);
        System.out.println("navigableSet: "+ navigableSetFlase.toString());

        //返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。
        Object higher = ((TreeSet) treeSet).higher("Hive");
        System.out.println("higher: "+higher);

        //  如果此 set 不包含任何元素，则返回 true。
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("is empty: "+ isEmpty);

        //返回在此 set 中的元素上按升序进行迭代的迭代器。
        Iterator iterator = treeSet.iterator();
        System.out.print("iterator: ");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        // 返回此 set 中当前最后一个（最高）元素。
        Object last = ((TreeSet) treeSet).last();
        System.out.println("last: "+last);

        // 返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。
        Object lower = ((TreeSet) treeSet).lower("Java");
        System.out.println("lower: "+lower);

        // 获取并移除第一个（最低）元素；如果此 set 为空，则返回 null。
        Object pollFirst = ((TreeSet) treeSet).pollFirst();
        System.out.println("pollFirst: "+ pollFirst);

        System.out.println("treeSet: "+ treeSet.toString());

        // 获取并移除最后一个（最高）元素；如果此 set 为空，则返回 null。
        Object pollLast = ((TreeSet) treeSet).pollLast();
        System.out.println("pollLast: "+ pollLast);

        System.out.println("treeSet: "+ treeSet.toString());


        // 将指定的元素从 set 中移除（如果该元素存在于此 set 中）。
        boolean removeHello = treeSet.remove("Hello");
        System.out.println("removeHello: "+ removeHello);
        System.out.println("treeSet: "+ treeSet.toString());

        //返回 set 中的元素数（set 的容量）。
        int size = treeSet.size();
        System.out.println("size: "+size);

        //返回此 set 的部分视图，其元素范围从 fromElement 到 toElement。
        NavigableSet subSet = ((TreeSet) treeSet).subSet("2", true,"Hive", true);
        System.out.println("subSet: "+subSet.toString());

        //返回此 set 的部分视图，其元素从 fromElement（包括）到 toElement（不包括）
        SortedSet subSet1 = ((TreeSet) treeSet).subSet("2", "Hive");
        System.out.println("subSet1: "+ subSet1.toString());

        // 返回此 set 的部分视图，其元素大于等于 fromElement。
        SortedSet tailSet = ((TreeSet) treeSet).tailSet("2");
        System.out.println("tailSet: "+ tailSet.toString());

        //返回此 set 的部分视图，其元素大于（或等于，如果 inclusive 为 true）fromElement。
        NavigableSet tailSet1 = ((TreeSet) treeSet).tailSet("2",false);
        System.out.println("tailSet1: "+ tailSet1);

    }
}
