package javacollection.map;


import java.util.*;

/**
 * @ClassName LearnHashTable
 * @Author zhangqx02
 * @Date 2019/9/9 10:37
 * @Description
 * 学习HashTable类
 *
 *构造方法摘要
 *  * Hashtable()
 *  *           用默认的初始容量 (11) 和加载因子 (0.75) 构造一个新的空哈希表。
 *
 *  * Hashtable(int initialCapacity)
 *  *           用指定初始容量和默认的加载因子 (0.75) 构造一个新的空哈希表。
 *
 *  * Hashtable(int initialCapacity, float loadFactor)
 *  *           用指定初始容量和指定加载因子构造一个新的空哈希表。
 *
 *  * Hashtable(Map<? extends K,? extends V> t)
 *  *           构造一个与给定的 Map 具有相同映射关系的新哈希表。
 *
 *方法摘要
 *  *  void	clear()
 *  *           将此哈希表清空，使其不包含任何键。
 *
 *  *  Object	clone()
 *  *           创建此哈希表的浅表副本。
 *
 *  *  boolean	contains(Object value)
 *  *           测试此映射表中是否存在与指定值关联的键。
 *
 *  *  boolean	containsKey(Object key)
 *  *           测试指定对象是否为此哈希表中的键。
 *
 *  *  boolean	containsValue(Object value)
 *  *           如果此 Hashtable 将一个或多个键映射到此值，则返回 true。
 *
 *  *  Enumeration<V>	elements()
 *  *           返回此哈希表中的值的枚举。
 *
 *  *  Set<Map.Entry<K,V>>	entrySet()
 *  *           返回此映射中包含的键的 Set 视图。
 *
 *  *  boolean	equals(Object o)
 *  *           按照 Map 接口的定义，比较指定 Object 与此 Map 是否相等。
 *
 *  *  V	get(Object key)
 *  *           返回指定键所映射到的值，如果此映射不包含此键的映射，则返回 null. 更确切地讲，如果此映射包含满足 (key.equals(k)) 的从键 k 到值 v 的映射，则此方法返回 v；否则，返回 null。
 *
 *  *  int	hashCode()
 *  *           按照 Map 接口的定义，返回此 Map 的哈希码值。
 *
 *  *  boolean	isEmpty()
 *  *           测试此哈希表是否没有键映射到值。
 *
 *  *  Enumeration<K>	keys()
 *  *           返回此哈希表中的键的枚举。
 *
 *  *  Set<K>	keySet()
 *  *           返回此映射中包含的键的 Set 视图。
 *
 *  *  V	put(K key, V value)
 *  *           将指定 key 映射到此哈希表中的指定 value。
 *
 *  *  void	putAll(Map<? extends K,? extends V> t)
 *  *           将指定映射的所有映射关系复制到此哈希表中，这些映射关系将替换此哈希表拥有的、针对当前指定映射中所有键的所有映射关系。
 *
 *  * protected  void	rehash()
 *  *           增加此哈希表的容量并在内部对其进行重组，以便更有效地容纳和访问其元素。
 *
 *  *  V	remove(Object key)
 *  *           从哈希表中移除该键及其相应的值。
 *
 *  *  int	size()
 *  *           返回此哈希表中的键的数量。
 *
 *  *  String	toString()
 *  *           返回此 Hashtable 对象的字符串表示形式，其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目。
 *
 *  *  Collection<V>	values()
 *  *           返回此映射中包含的键的 Collection 视图。
 *
 * 从类 java.lang.Object 继承的方法
 *  * finalize, getClass, notify, notifyAll, wait, wait, wait
 */

public class LearnHashTable {
    public static void main(String[] args){
        Hashtable<String,Integer> hashtable = new Hashtable<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("Hadoop", 80);
        map.put("Spark", 99);
        map.put("Hive", 78);

        hashtable.putAll(map);
        hashtable.put("Hbase", 88);
        hashtable.put("", 91);

        // 测试此映射表中是否存在与指定值关联的键。
        boolean isContains90Key = hashtable.contains(90);
        System.out.println("hashtable contains key of value=90: "+ isContains90Key);

        // 返回此哈希表中的值的枚举。
        Enumeration enumeration = hashtable.elements();
        while (enumeration.hasMoreElements()){
            Integer key = (Integer) enumeration.nextElement();
            System.out.println("enumeration: "+ key);
        }

        // 返回此映射中包含的键的 Collection 视图。
        Collection collection = hashtable.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Integer value = (Integer)iterator.next();
            System.out.println("collection: "+ value);
        }


        // 按照 Map 接口的定义，返回此 Map 的哈希码值。
        int hashCode = hashtable.hashCode();
        System.out.println("hashtable hashCode: "+ hashCode);

        //返回此哈希表中的键的枚举。
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()){
            System.out.println("keys: "+ keys.nextElement());
        }

        // 返回此 Hashtable 对象的字符串表示形式，其形式为 ASCII 字符 ", " （逗号加空格）分隔开的、括在括号中的一组条目。
        String result = hashtable.toString();
        System.out.println("hashtable call toString(): "+ result);

    }
}
