package javacollection.list;


import java.util.*;

/**
 * @ClassName LearnVector
 * @Author zhangqx02
 * @Date 2019/9/19 19:17
 * @Description
 *
 * 字段摘要
 *      protected  int capacityIncrement
 *                向量的大小大于其容量时，容量自动增加的量。
 *      protected  int elementCount
 *                Vector 对象中的有效组件数。
 *      protected  Object[] elementData
 *                存储向量组件的数组缓冲区。
 *
 * 从类 java.util.AbstractList 继承的字段
 *      modCount
 *
 * 构造方法摘要
 *      Vector()
 *                构造一个空向量，使其内部数据数组的大小为 10，其标准容量增量为零。
 *      Vector(Collection<? extends E> c)
 *                构造一个包含指定 collection 中的元素的向量，这些元素按其 collection 的迭代器返回元素的顺序排列。
 *      Vector(int initialCapacity)
 *                使用指定的初始容量和等于零的容量增量构造一个空向量。
 *      Vector(int initialCapacity, int capacityIncrement)
 *                使用指定的初始容量和容量增量构造一个空的向量。
 *
 * 方法摘要
 *       boolean  add(E e)
 *                将指定元素添加到此向量的末尾。
 *       void     add(int index, E element)
 *                在此向量的指定位置插入指定的元素。
 *       boolean  addAll(Collection<? extends E> c)
 *                将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。
 *       boolean  addAll(int index, Collection<? extends E> c)
 *                在指定位置将指定 Collection 中的所有元素插入到此向量中。
 *       void     addElement(E obj)
 *                将指定的组件添加到此向量的末尾，将其大小增加 1。
 *       int capacity()
 *                返回此向量的当前容量。
 *       void     clear()
 *                从此向量中移除所有元素。
 *       Object   clone()
 *                返回向量的一个副本。
 *       boolean  contains(Object o)
 *                如果此向量包含指定的元素，则返回 true。
 *       boolean  containsAll(Collection<?> c)
 *                如果此向量包含指定 Collection 中的所有元素，则返回 true。
 *       void     copyInto(Object[] anArray)
 *                将此向量的组件复制到指定的数组中。
 *       E   elementAt(int index)
 *                返回指定索引处的组件。
 *       Enumeration<E>     elements()
 *                返回此向量的组件的枚举。
 *       void     ensureCapacity(int minCapacity)
 *                增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。
 *       boolean  equals(Object o)
 *                比较指定对象与此向量的相等性。
 *       E   firstElement()
 *                返回此向量的第一个组件（位于索引 0) 处的项）。
 *       E   get(int index)
 *                返回向量中指定位置的元素。
 *       int hashCode()
 *                返回此向量的哈希码值。
 *       int indexOf(Object o)
 *                返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。
 *       int indexOf(Object o, int index)
 *                返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。
 *       void     insertElementAt(E obj, int index)
 *                将指定对象作为此向量中的组件插入到指定的 index 处。
 *       boolean  isEmpty()
 *                测试此向量是否不包含组件。
 *       E   lastElement()
 *                返回此向量的最后一个组件。
 *       int lastIndexOf(Object o)
 *                返回此向量中最后一次出现的指定元素的索引；如果此向量不包含该元素，则返回 -1。
 *       int lastIndexOf(Object o, int index)
 *                返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。
 *       E   remove(int index)
 *                移除此向量中指定位置的元素。
 *       boolean  remove(Object o)
 *                移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。
 *       boolean  removeAll(Collection<?> c)
 *                从此向量中移除包含在指定 Collection 中的所有元素。
 *       void     removeAllElements()
 *                从此向量中移除全部组件，并将其大小设置为零。
 *       boolean  removeElement(Object obj)
 *                从此向量中移除变量的第一个（索引最小的）匹配项。
 *       void     removeElementAt(int index)
 *                删除指定索引处的组件。
 *      protected  void     removeRange(int fromIndex, int toIndex)
 *                从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。
 *       boolean  retainAll(Collection<?> c)
 *                在此向量中仅保留包含在指定 Collection 中的元素。
 *       E   set(int index, E element)
 *                用指定的元素替换此向量中指定位置处的元素。
 *       void     setElementAt(E obj, int index)
 *                将此向量指定 index 处的组件设置为指定的对象。
 *       void     setSize(int newSize)
 *                设置此向量的大小。
 *       int size()
 *                返回此向量中的组件数。
 *       List<E>  subList(int fromIndex, int toIndex)
 *                返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
 *       Object[] toArray()
 *                返回一个数组，包含此向量中以恰当顺序存放的所有元素。
 *      <T> T[]   toArray(T[] a)
 *                返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。
 *       String   toString()
 *                返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。
 *       void     trimToSize()
 *                对此向量的容量进行微调，使其等于向量的当前大小。
 *
 * 继承方法
 *      从类 java.util.AbstractList 继承的方法
 *           iterator, listIterator, listIterator
 *
 *      从类 java.lang.Object 继承的方法
 *           finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 *      从接口 java.util.List 继承的方法
 *           iterator, listIterator, listIterator
 */

public class LearnVector {
    public static void main(String[] args){
//        vectorMethod();
        Vector vector = new Vector();
        for(int i =0 ;i <10000000;i++ ){
            vector.add(i);
        }
        iteratorThroughEnumeration(vector);
        iteratorThroughRandomAccess(vector);
        iteratorThroughFor2(vector);
        iteratorThroughIterator(vector);
    }

    private static void vectorMethod(){

        //  构造一个空向量，使其内部数据数组的大小为 10，其标准容量增量为零。
        Vector vector = new Vector();

        vector.add("Hadoop");
        vector.add("Spark");

        String[] language = {"Scala","Java","C++"};

        //将指定 Collection 中的所有元素添加到此向量的末尾，按照指定 collection 的迭代器所返回的顺序添加这些元素。
        vector.addAll(Arrays.asList(language));

        System.out.println("vector: "+ vector.toString());

        //   返回此向量的当前容量。
        int capacity = vector.capacity();
        System.out.println("capacity: "+ capacity);

        //  返回此向量中的组件数。
        int size = vector.size();
        System.out.println("size: "+ size);

        vector.trimToSize();
        // 对此向量的容量进行微调，使其等于向量的当前大小。
        int trimCapacity = vector.capacity();
        System.out.println("trimCapacity: "+ trimCapacity);

        // 在此向量的指定位置插入指定的元素。
        vector.add(0,"Hive");
        System.out.println("vector: "+ vector.toString());

        //  将此向量的组件复制到指定的数组中。
        String[] strArray = new  String[10];
        vector.copyInto(strArray);
        int index = 0;
        while (strArray[index] != null){
            System.out.println("strArray: "+ strArray[index]);
            index++;
        }

        // 返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
        List list = vector.subList(2, 4);
        System.out.println("list: "+ list.toString());

        //  在此向量中仅保留包含在指定 Collection 中的元素。
        String[] retain = {"Hadoop","Java","Scala"};
        vector.retainAll(Arrays.asList(retain));
        System.out.println("vector: "+vector.toString());

        // 返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
        Object[] objArr = vector.toArray();
        for (Object obj:objArr) {
            System.out.println("toArray: "+ obj);
        }

        // 返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。
        String[] strArr = (String[]) vector.toArray(new String[0]);
        for (String string:strArr) {
            System.out.println("strArr: "+ string);

        }

        System.out.println();

    }
    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    public static void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }

    public static void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }


    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }

    public static void iteratorThroughEnumeration(Vector vec) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Enumeration enu = vec.elements(); enu.hasMoreElements(); ) {
            enu.nextElement();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughEnumeration：" + interval+" ms");
    }

}
