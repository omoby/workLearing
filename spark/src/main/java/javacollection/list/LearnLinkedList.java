package javacollection.list;


import java.util.*;

/**
 * @ClassName LearnLinkedList
 * @Author zhangqx02
 * @Date 2019/9/19 9:05
 * @Description
 *
 * 字段摘要
 *      从类 java.util.AbstractList 继承的字段
 *                modCount
 *
 * 构造方法摘要
 *      LinkedList()
 *                构造一个空列表。
 *      LinkedList(Collection<? extends E> c)
 *                构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列。
 *
 * 方法摘要
 *       boolean	add(E e)
 *                将指定元素添加到此列表的结尾。
 *       void	add(int index, E element)
 *                在此列表中指定的位置插入指定的元素。
 *       boolean	addAll(Collection<? extends E> c)
 *                添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。
 *       boolean	addAll(int index, Collection<? extends E> c)
 *                将指定 collection 中的所有元素从指定位置开始插入此列表。
 *       void	addFirst(E e)
 *                将指定元素插入此列表的开头。
 *       void	addLast(E e)
 *                将指定元素添加到此列表的结尾。
 *       void	clear()
 *                从此列表中移除所有元素。
 *       Object	clone()
 *                返回此 LinkedList 的浅表副本。
 *       boolean	contains(Object o)
 *                如果此列表包含指定元素，则返回 true。
 *
 *       Iterator<E>	descendingIterator()
 *                返回以逆向顺序在此双端队列的元素上进行迭代的迭代器。
 *       E	element()
 *                获取但不移除此列表的头（第一个元素）。
 *       E	get(int index)
 *                返回此列表中指定位置处的元素。
 *       E	getFirst()
 *                返回此列表的第一个元素。
 *       E	getLast()
 *                返回此列表的最后一个元素。
 *       int	indexOf(Object o)
 *                返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
 *       int	lastIndexOf(Object o)
 *                返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
 *
 *       ListIterator<E>	listIterator(int index)
 *                返回此列表中的元素的列表迭代器（按适当顺序），从列表中指定位置开始。
 *       boolean	offer(E e)
 *                将指定元素添加到此列表的末尾（最后一个元素）。
 *       boolean	offerFirst(E e)
 *                在此列表的开头插入指定的元素。
 *       boolean	offerLast(E e)
 *                在此列表末尾插入指定的元素。
 *       E	peek()
 *                获取但不移除此列表的头（第一个元素）。
 *       E	peekFirst()
 *                获取但不移除此列表的第一个元素；如果此列表为空，则返回 null。
 *       E	peekLast()
 *                获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null。
 *       E	poll()
 *                获取并移除此列表的头（第一个元素）
 *       E	pollFirst()
 *                获取并移除此列表的第一个元素；如果此列表为空，则返回 null。
 *       E	pollLast()
 *                获取并移除此列表的最后一个元素；如果此列表为空，则返回 null。
 *       E	pop()
 *                从此列表所表示的堆栈处弹出一个元素。
 *       void	push(E e)
 *                将元素推入此列表所表示的堆栈。
 *       E	remove()
 *                获取并移除此列表的头（第一个元素）。
 *       E	remove(int index)
 *                移除此列表中指定位置处的元素。
 *       boolean	remove(Object o)
 *                从此列表中移除首次出现的指定元素（如果存在）。
 *       E	removeFirst()
 *                移除并返回此列表的第一个元素。
 *       boolean	removeFirstOccurrence(Object o)
 *                从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。
 *       E	removeLast()
 *                移除并返回此列表的最后一个元素。
 *       boolean	removeLastOccurrence(Object o)
 *                从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）。
 *       E	set(int index, E element)
 *                将此列表中指定位置的元素替换为指定的元素。
 *       int	size()
 *                返回此列表的元素数。
 *       Object[]	toArray()
 *                返回以适当顺序（从第一个元素到最后一个元素）包含此列表中所有元素的数组。
 *      <T> T[]	toArray(T[] a)
 *                返回以适当顺序（从第一个元素到最后一个元素）包含此列表中所有元素的数组；返回数组的运行时类型为指定数组的类型。
 *
 * 继承方法
 *      从类 java.util.AbstractSequentialList 继承的方法
 *           iterator
 *
 *      从类 java.util.AbstractList 继承的方法
 *           equals, hashCode, listIterator, removeRange, subList
 *
 *      从类 java.util.AbstractCollection 继承的方法
 *           containsAll, isEmpty, removeAll, retainAll, toString
 *
 *      从类 java.lang.Object 继承的方法
 *           finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 *      从接口 java.util.List 继承的方法
 *           containsAll, equals, hashCode, isEmpty, iterator, listIterator, removeAll, retainAll, subList
 *
 *      从接口 java.util.Deque 继承的方法
 *           iterator
 *
 *
 */

public class LearnLinkedList {

    public static void main(String[] args){
        linkedListMethod();
//        LinkedList<Integer> list = getLinkedList();

        /**
         * LinkedList遍历方式时间开销对比
         */
        linkedListIteratorTravesing(getLinkedList());
        linkedListForStravesing( getLinkedList());
        linkedListPollFirstTravesing( getLinkedList());
        linkedListPollLastTravesing( getLinkedList());
        linkedListRemoveFirstTravesing( getLinkedList());
        linkedListRemoveLastTravesing( getLinkedList());
        linkedListRandomTraversing( getLinkedList());
    }

    private static void linkedListMethod(){
        String[] strings = {"Hadoop","Spark","Scala","Java"};

        //构造一个包含指定 collection 中的元素的列表，这些元素按其 collection 的迭代器返回的顺序排列。
        LinkedList linkedList = new LinkedList(Arrays.asList(strings));
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //构造一个空列表。
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add("Hive");
        linkedList1.add("Hbase");
        linkedList1.add("Flink");
        System.out.println("linkedList1: "+ linkedList1.toString()+"\n");

        //在此列表中指定的位置插入指定的元素。
        linkedList1.add(1, "MySQL");
        System.out.println("call add(index,element): "+linkedList1.toString()+"\n");

        //添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。
        linkedList.addAll(linkedList1);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");


        List list = new ArrayList();
        list.add("Oracle");
        list.add("SQLServer");
        // 将指定 collection 中的所有元素从指定位置开始插入此列表。
        linkedList.addAll(1, list);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //将指定元素插入此列表的开头。
        linkedList.addFirst("HTML");
        System.out.println("addFirst: "+ linkedList.toString()+"\n");

        //将指定元素添加到此列表的结尾。
        linkedList.addLast("JSP");
        System.out.println("addLast: "+ linkedList.toString()+"\n");

        // 从此列表中移除所有元素。
        linkedList.clear();
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //返回此 LinkedList 的浅表副本。
        linkedList = (LinkedList) linkedList1.clone();
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        // 返回以逆向顺序在此双端队列的元素上进行迭代的迭代器。
        Iterator iter = linkedList.descendingIterator();

        while (iter.hasNext()){
            String str = (String)iter.next();
            System.out.println("str: "+ str);
            if ("Hive".equals(str)){
                iter.remove();
            }
        }
        System.out.println("linkedList: "+ linkedList.toString()+"\n");


        //  获取但不移除此列表的头（第一个元素）
        String string = (String)linkedList.element();
        System.out.println("element: "+ string);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //返回此列表中指定位置处的元素。
        String getElement = (String)linkedList.get(1);
        System.out.println("getElement: "+ getElement);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //返回此列表的第一个元素
        String getFirst = (String) linkedList.getFirst();
        System.out.println("getFirst: "+ getFirst);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");
        //返回此列表的最后一个元素。
        String getLast  = (String)linkedList.getLast();
        System.out.println("getLast； "+ getLast);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");


        linkedList.addLast("Flink");
        //返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
        int index = linkedList.indexOf("Flink");
        System.out.println("index: "+ index);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");
        int index1 = linkedList.indexOf("Spark");
        System.out.println("index1: "+index1);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
        int lastIndexOf = linkedList.lastIndexOf("Flink");
        System.out.println("lastIndexOf: "+ lastIndexOf);
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

        //返回此列表中的元素的列表迭代器（按适当顺序），从列表中指定位置开始。
        ListIterator lIter = linkedList.listIterator(0);
        while (lIter.hasNext()){
            lIter.next();
        }
        while (lIter.hasPrevious()){
            String pre = (String)lIter.previous();
            System.out.println("pre: "+ pre);
        }
        System.out.println("linkedList: "+ linkedList.toString()+"\n");

    }

    private static LinkedList getLinkedList(){
        int range = 100000;
        LinkedList<Integer> list = new LinkedList();
        for(int i = 0; i < range;i++){
            list.add(i);
        }
        return list;
    }

    /**
     * 通过快迭代器遍历LinkedList
     */
    private static void linkedListIteratorTravesing(LinkedList<Integer> list) {
        if(list == null){
            return ;
        }


        // 记录开始时间
        long start = System.currentTimeMillis();

        for(Iterator iter = list.iterator(); iter.hasNext();){
            iter.next();
        }


        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListIteratorTravesing：" + interval+" ms");
    }
    /**
     * 通过快速随机访问遍历
     * @param list
     */
    private static void linkedListRandomTraversing(LinkedList<Integer> list){
        if (list == null){
            return;
        }
        //获取开始时间
        long start = System.currentTimeMillis();
        int length  = list.size();
        for(int i = 0; i < length; i++){
            list.get(i);
        }
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListRandomTraversing: "+ interval+"ms");
    }

    /**
     * 通过另外一种for循环来遍历LinkedList
     */
    private static void linkedListForStravesing(LinkedList<Integer> list) {
        if (list == null){
            return ;
        }


        // 记录开始时间
        long start = System.currentTimeMillis();

        for (Integer integ:list){

        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListForStravesing：" + interval+" ms");
    }

    /**
     * 通过pollFirst()来遍历LinkedList
     */
    private static void linkedListPollFirstTravesing(LinkedList<Integer> list) {
        if (list == null){
            return ;
        }


        // 记录开始时间
        long start = System.currentTimeMillis();
        while(list.pollFirst() != null){

        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListPollFirstTravesing：" + interval+" ms");
    }

    /**
     * 通过pollLast()来遍历LinkedList
     */
    private static void linkedListPollLastTravesing(LinkedList<Integer> list) {
        if (list == null){
            return ;
        }


        // 记录开始时间
        long start = System.currentTimeMillis();
        while(list.pollLast() != null){

        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListPollLastTravesing：" + interval+" ms");
    }

    /**
     * 通过removeFirst()来遍历LinkedList
     */
    private static void linkedListRemoveFirstTravesing(LinkedList<Integer> list) {
        if (list == null){
            return ;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            while(list.removeFirst() != null){

            }
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListRemoveFirstTravesing：" + interval+" ms");
    }

    /**
     * 通过removeLast()来遍历LinkedList
     */
    private static void linkedListRemoveLastTravesing(LinkedList<Integer> list) {
        if (list == null){
            return ;
        }

        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            Integer inter =list.removeLast();
            while(inter != null){
                inter = list.removeLast();
            }
        } catch (NoSuchElementException e) {
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        long interval = end - start;
        System.out.println("linkedListRemoveLastTravesing：" + interval+" ms");
    }

}
