package javacollection.map;

import java.util.*;

/**
 * @ClassName HashMap
 * @Author zhangqx02
 * @Date 2019/9/7 10:45
 * @Description
 * 学习HaspMap
 *
 * * 构造方法摘要
 *      * HashMap()
 *      *           构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。
 *      * HashMap(int initialCapacity)
 *      *           构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
 *      * HashMap(int initialCapacity, float loadFactor)
 *      *           构造一个带指定初始容量和加载因子的空 HashMap。
 *      * HashMap(Map<? extends K,? extends V> m)
 *      *           构造一个映射关系与指定 Map 相同的新 HashMap。
 *      *
 * 方法摘要
 *      *  void	clear()
 *      *           从此映射中移除所有映射关系。
 *      *  Object	clone()
 *      *           返回此 HashMap 实例的浅表副本：并不复制键和值本身。
 *      *  boolean	containsKey(Object key)
 *      *           如果此映射包含对于指定键的映射关系，则返回 true。
 *      *  boolean	containsValue(Object value)
 *      *           如果此映射将一个或多个键映射到指定值，则返回 true。
 *      *  Set<Map.Entry<K,V>>	entrySet()
 *      *           返回此映射所包含的映射关系的 Set 视图。
 *      *  V	get(Object key)
 *      *           返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null。
 *      *  boolean	isEmpty()
 *      *           如果此映射不包含键-值映射关系，则返回 true。
 *      *  Set<K>	keySet()
 *      *           返回此映射中所包含的键的 Set 视图。
 *      *  V	put(K key, V value)
 *      *           在此映射中关联指定值与指定键。
 *      *  void	putAll(Map<? extends K,? extends V> m)
 *      *           将指定映射的所有映射关系复制到此映射中，这些映射关系将替换此映射目前针对指定映射中所有键的所有映射关系。
 *      *  V	remove(Object key)
 *      *           从此映射中移除指定键的映射关系（如果存在）。
 *      *  int	size()
 *      *           返回此映射中的键-值映射关系数。
 *      *  Collection<V>	values()
 *      *           返回此映射所包含的值的 Collection 视图。
 */

public class LearnHashMap {
    public static void main(String[] args){
        Map<String,Double> softWare = new HashMap<>();
        Map<String,Double> map = new HashMap<>();
        //在此映射中关联指定值与指定键。
        map.put("Hadoop", 80.0);
        map.put("Spark", 90.5);
        //将指定映射的所有映射关系复制到此映射中，这些映射关系将替换此映射目前针对指定映射中所有键的所有映射关系。
        softWare.putAll(map);
        softWare.put("flink",90.0);

        //如果此映射包含对于指定键的映射关系，则返回 true。
        boolean isContainsHBase = softWare.containsKey("Hbase");
        System.out.println("softWare is contains Hbase: "+ isContainsHBase);

        boolean isContainsHadoop = softWare.containsKey("Hadoop");
        System.out.println("softWare is contains Hadoop: "+ isContainsHadoop);

        //如果此映射将一个或多个键映射到指定值，则返回 true。
        boolean hiveScore = softWare.containsValue(70.0);
        System.out.println("softWare contains value 70.0: "+hiveScore);

        boolean sparkScore = softWare.containsValue(90.5);
        System.out.println("softWare contains value 90.5: "+ sparkScore);

        //返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null。
       double sparkScoreGet =  softWare.get("Spark");
       System.out.println("Call get(): "+ sparkScoreGet);

       //如果此映射不包含键-值映射关系，则返回 true。
       boolean isEmpty = softWare.isEmpty();
       System.out.println("softWare is empty: "+ isEmpty);

       //返回此映射中所包含的键的 Set 视图。
        Set<String> name = softWare.keySet();
        Iterator iterator = name.iterator();
        while (iterator.hasNext()){
            String softName = String.valueOf(iterator.next());
            System.out.println("soft name: "+softName);
        }

        //返回此映射所包含的映射关系的 Set 视图。
        for(Map.Entry entry: softWare.entrySet()){
            String soft = String.valueOf(entry.getKey());
            double score = (double)entry.getValue();
            System.out.println("soft: "+ soft + " score: "+score);
        }

        //返回此映射中的键-值映射关系数。
        int size = softWare.size();
        System.out.println("soft ware size: "+ size);


        //回此映射所包含的值的 Collection 视图。
        Collection<Double> values = softWare.values();
        Iterator<Double> iteratorValues = values.iterator();
        while (iteratorValues.hasNext()){
            double val = iteratorValues.next();
            System.out.println("Values: "+ val);
        }

        softWare.remove("flink");
        for(Map.Entry entry: softWare.entrySet()){
            String soft = String.valueOf(entry.getKey());
            double score = (double)entry.getValue();
            System.out.println("soft: "+ soft + " score: "+score);
        }

        Map<String,Double> cloneMap = (Map<String, Double>) ((HashMap<String, Double>) softWare).clone();

        for(Map.Entry entry: cloneMap.entrySet()){
            String soft = String.valueOf(entry.getKey());
            double score = (double)entry.getValue();
            System.out.println("cloneMap: "+ soft + " score: "+score);
        }

       //从此映射中移除所有映射关系。
        cloneMap.clear();

        System.out.println("cloneMap is empty: "+ cloneMap.isEmpty());

    }
}
