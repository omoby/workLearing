package javacollection.map;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LearnLinkedHashMap
 * @Author zhangqx02
 * @Date 2019/9/7 15:55
 * @Description
 *
 *构造方法摘要
 *      * LinkedHashMap()
 *      *           构造一个带默认初始容量 (16) 和加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
 *
 *      * LinkedHashMap(int initialCapacity)
 *      *           构造一个带指定初始容量和默认加载因子 (0.75) 的空插入顺序 LinkedHashMap 实例。
 *
 *      * LinkedHashMap(int initialCapacity, float loadFactor)
 *      *           构造一个带指定初始容量和加载因子的空插入顺序 LinkedHashMap 实例。
 *
 *      * LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
 *      *           构造一个带指定初始容量、加载因子和排序模式的空 LinkedHashMap 实例。
 *
 *      * LinkedHashMap(Map<? extends K,? extends V> m)
 *      *           构造一个映射关系与指定映射相同的插入顺序 LinkedHashMap 实例。
 *
 *方法摘要
 *      *  void	clear()
 *      *           从该映射中移除所有映射关系。
 *
 *      *  boolean	containsValue(Object value)
 *      *           如果此映射将一个或多个键映射到指定值，则返回 true。
 *
 *      *  V	get(Object key)
 *      *           返回此映射到指定键的值。
 *
 *      * protected  boolean	removeEldestEntry(Map.Entry<K,V> eldest)
 *      *           如果此映射移除其最旧的条目，则返回 true。
 *
 *
 *从类 java.util.HashMap 继承的方法
 *      * clone, containsKey, entrySet, isEmpty, keySet, put, putAll, remove, size, values
 *
 *从类 java.util.AbstractMap 继承的方法
 *      * equals, hashCode, toString
 *
 * * 从类 java.lang.Object 继承的方法
 *      * finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 * * 从接口 java.util.Map 继承的方法
 *      * containsKey, entrySet, equals, hashCode, isEmpty, keySet, put, putAll, remove, size, values
 */

public class LearnLinkedHashMap {
    public static void main(String[] args){
        Map<String,Double> softWare = new LinkedHashMap<>();

        softWare.put("Hadoop",90.0);
        softWare.put("Spark", 99.0);
        softWare.put("Hbase", 80.0);

        boolean isContains = softWare.containsValue(90.0);
        System.out.println("softWare contains 90.0: "+ isContains);

        double score = (double)softWare.get("Hadoop");
        System.out.println("Hadoop's score is: "+ score);


        softWare.clear();
        System.out.println("softWare size is :"+ softWare.size());

    }
}
