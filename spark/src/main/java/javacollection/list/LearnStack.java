package javacollection.list;


import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName LearnStack
 * @Author zhangqx02
 * @Date 2019/9/20 9:06
 * @Description
 *
 * 字段摘要
 * 	从类 java.util.Vector 继承的字段
 * 		capacityIncrement, elementCount, elementData
 * 	从类 java.util.AbstractList 继承的字段
 * 		modCount
 *
 * 构造方法摘要
 * 	Stack()
 * 	          创建一个空堆栈。
 *
 * 方法摘要
 * 	 boolean	empty()
 * 	          测试堆栈是否为空。
 * 	 E	peek()
 * 	          查看堆栈顶部的对象，但不从堆栈中移除它。
 * 	 E	pop()
 * 	          移除堆栈顶部的对象，并作为此函数的值返回该对象。
 * 	 E	push(E item)
 * 	          把项压入堆栈顶部。
 * 	 int	search(Object o)
 * 	          返回对象在堆栈中的位置，以 1 为基数。
 *
 * 继承方法
 * 	从类 java.util.Vector 继承的方法
 * 		add, add, addAll, addAll, addElement, capacity, clear, clone, contains, containsAll, copyInto, elementAt, elements, ensureCapacity, equals, firstElement, get, hashCode, indexOf, indexOf, insertElementAt, isEmpty, lastElement, lastIndexOf, lastIndexOf, remove, remove, removeAll, removeAllElements, removeElement, removeElementAt, removeRange, retainAll, set, setElementAt, setSize, size, subList, toArray, toArray, toString, trimToSize
 *
 * 	从类 java.util.AbstractList 继承的方法
 * 		iterator, listIterator, listIterator
 *
 * 	从类 java.lang.Object 继承的方法
 * 		finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 * 	从接口 java.util.List 继承的方法
 * 		iterator, listIterator, listIterator
 */

public class LearnStack {
    public static void main(String[] args){
        // 创建一个空堆栈。
        Stack stack = new Stack();

        //测试堆栈是否为空。
        boolean isEmpty = stack.empty();
        System.out.println("stack is empty: "+ isEmpty);

        // 把项压入堆栈顶部。
        stack.push("Hadoop");
        stack.push("Spark");
        stack.push("Hive");
        String[] str = {"Scala","Java","C++"};
        stack.addAll(Arrays.asList(str));

        System.out.println("stack: "+ stack.toString());

        //查看堆栈顶部的对象，但不从堆栈中移除它。
        Object first = stack.peek();
        System.out.println("first: "+ first);

        int size = stack.size();
        System.out.println("size: "+ size);

        //返回对象在堆栈中的位置，以 1 为基数。
        int indexOfHadoop = stack.search("Hadoop");
        System.out.println("indexOfHadoop: "+ indexOfHadoop);

        while (!stack.empty()){
            // 移除堆栈顶部的对象，并作为此函数的值返回该对象。
            System.out.println("pop: "+ stack.pop());
        }

        size = stack.size();
        int capacity = stack.capacity();
        isEmpty = stack.empty();
        System.out.println("size； "+ size+", capacity: "+ capacity+", isEmpty: "+ isEmpty );

    }
}
