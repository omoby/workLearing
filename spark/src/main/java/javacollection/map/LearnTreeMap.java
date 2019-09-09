package javacollection.map;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName LearnTreeMap
 * @Author zhangqx02
 * @Date 2019/9/9 9:42
 * @Description
 * 学习TreeMap
 *
 *构造方法摘要
 *  * TreeMap()
 *  *           使用键的自然顺序构造一个新的、空的树映射。
 *  * TreeMap(Comparator<? super K> comparator)
 *  *           构造一个新的、空的树映射，该映射根据给定比较器进行排序。
 *  * TreeMap(Map<? extends K,? extends V> m)
 *  *           构造一个与给定映射具有相同映射关系的新的树映射，该映射根据其键的自然顺序 进行排序。
 *  * TreeMap(SortedMap<K,? extends V> m)
 *  *           构造一个与指定有序映射具有相同映射关系和相同排序顺序的新的树映射。
 *
 *方法摘要
 *  *  Map.Entry<K,V>	ceilingEntry(K key)
 *  *           返回一个键-值映射关系，它与大于等于给定键的最小键关联；如果不存在这样的键，则返回 null。
 *
 *  *  K	ceilingKey(K key)
 *  *           返回大于等于给定键的最小键；如果不存在这样的键，则返回 null。
 *
 *  *  void	clear()
 *  *           从此映射中移除所有映射关系。
 *
 *  *  Object	clone()
 *  *           返回此 TreeMap 实例的浅表副本。
 *
 *  *  Comparator<? super K>	comparator()
 *  *           返回对此映射中的键进行排序的比较器；如果此映射使用键的自然顺序，则返回 null。
 *
 *  *  boolean	containsKey(Object key)
 *  *           如果此映射包含指定键的映射关系，则返回 true。
 *
 *  *  boolean	containsValue(Object value)
 *  *           如果此映射为指定值映射一个或多个键，则返回 true。
 *
 *  *  NavigableSet<K>	descendingKeySet()
 *  *           返回此映射中所包含键的逆序 NavigableSet 视图。
 *
 *  *  NavigableMap<K,V>	descendingMap()
 *  *           返回此映射中所包含映射关系的逆序视图。
 *
 *  *  Set<Map.Entry<K,V>>	entrySet()
 *  *           返回此映射中包含的映射关系的 Set 视图。
 *
 *  *  Map.Entry<K,V>	firstEntry()
 *  *           返回一个与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
 *
 *  *  K	firstKey()
 *  *           返回此映射中当前第一个（最低）键。
 *
 *  *  Map.Entry<K,V>	floorEntry(K key)
 *  *           返回一个键-值映射关系，它与小于等于给定键的最大键关联；如果不存在这样的键，则返回 null。
 *
 *  *  K	floorKey(K key)
 *  *           返回小于等于给定键的最大键；如果不存在这样的键，则返回 null。
 *
 *  *  V	get(Object key)
 *  *           返回指定键所映射的值，如果对于该键而言，此映射不包含任何映射关系，则返回 null。
 *
 *  *  SortedMap<K,V>	headMap(K toKey)
 *  *           返回此映射的部分视图，其键值严格小于 toKey。
 *
 *  *  NavigableMap<K,V>	headMap(K toKey, boolean inclusive)
 *  *           返回此映射的部分视图，其键小于（或等于，如果 inclusive 为 true）toKey。
 *
 *  *  Map.Entry<K,V>	higherEntry(K key)
 *  *           返回一个键-值映射关系，它与严格大于给定键的最小键关联；如果不存在这样的键，则返回 null。
 *
 *  *  K	higherKey(K key)
 *  *           返回严格大于给定键的最小键；如果不存在这样的键，则返回 null。
 *
 *  *  Set<K>	keySet()
 *  *           返回此映射包含的键的 Set 视图。
 *
 *  *  Map.Entry<K,V>	lastEntry()
 *  *           返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回 null。
 *
 *  *  K	lastKey()
 *  *           返回映射中当前最后一个（最高）键。
 *
 *  *  Map.Entry<K,V>	lowerEntry(K key)
 *  *           返回一个键-值映射关系，它与严格小于给定键的最大键关联；如果不存在这样的键，则返回 null。
 *
 *  *  K	lowerKey(K key)
 *  *           返回严格小于给定键的最大键；如果不存在这样的键，则返回 null。
 *
 *  *  NavigableSet<K>	navigableKeySet()
 *  *           返回此映射中所包含键的 NavigableSet 视图。
 *
 *  *  Map.Entry<K,V>	pollFirstEntry()
 *  *           移除并返回与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
 *
 *  *  Map.Entry<K,V>	pollLastEntry()
 *  *           移除并返回与此映射中的最大键关联的键-值映射关系；如果映射为空，则返回 null。
 *
 *  *  V	put(K key, V value)
 *  *           将指定值与此映射中的指定键进行关联。
 *
 *  *  void	putAll(Map<? extends K,? extends V> map)
 *  *           将指定映射中的所有映射关系复制到此映射中。
 *
 *  *  V	remove(Object key)
 *  *           如果此 TreeMap 中存在该键的映射关系，则将其删除。
 *
 *  *  int	size()
 *  *           返回此映射中的键-值映射关系数。
 *
 *  *  NavigableMap<K,V>	subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
 *  *           返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
 *
 *  *  SortedMap<K,V>	subMap(K fromKey, K toKey)
 *  *           返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。
 *
 *  *  SortedMap<K,V>	tailMap(K fromKey)
 *  *           返回此映射的部分视图，其键大于等于 fromKey。
 *
 *  *  NavigableMap<K,V>	tailMap(K fromKey, boolean inclusive)
 *  *           返回此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromKey。
 *
 *  *  Collection<V>	values()
 *  *           返回此映射包含的值的 Collection 视图。
 *
 *
 *从类 java.util.AbstractMap 继承的方法
 *  * equals, hashCode, isEmpty, toString
 *
 *从类 java.lang.Object 继承的方法
 *  * finalize, getClass, notify, notifyAll, wait, wait, wait
 *
 * 从接口 java.util.Map 继承的方法
 *  * equals, hashCode, isEmpty
 */

public class LearnTreeMap {
    public static void main(String[] args){
        Map<Integer,String> treeMap = new TreeMap();
        Map<Integer,String> map = new HashMap<>();
        map.put(80,"Hadoop");
        map.put(87,"Hbase");

        //将指定映射中的所有映射关系复制到此映射中。
        treeMap.putAll(map);

        //将指定值与此映射中的指定键进行关联。
        treeMap.put(99,"Spark");
        treeMap.put(98,"Flink");

        System.out.println("treeMap contains: ");
        //返回此映射中包含的映射关系的 Set 视图。
        for (Map.Entry entry: treeMap.entrySet()){
            //
            int key = (int)entry.getKey();
            String value = String.valueOf(entry.getValue());
            System.out.println("key: "+ key +" ,value: "+value);
        }

        //如果此映射包含指定键的映射关系，则返回 true。
        boolean isContains80 = treeMap.containsKey(80);
        System.out.println("treeMap contains key=80: "+ isContains80);

        boolean isContains100 = treeMap.containsKey(100);
        System.out.println("treeMap cantains key=100: "+ isContains100);

        //如果此映射为指定值映射一个或多个键，则返回 true。
        boolean isContainsValueSpark = treeMap.containsValue("Spark");
        System.out.println("treeMap contains value=Spark: "+ isContainsValueSpark);

        boolean isContainsValueHive = treeMap.containsValue("Hive");
        System.out.println("treeMap contains value=Hive: "+ isContainsValueHive);

        //返回一个与此映射中的最小键关联的键-值映射关系；如果映射为空，则返回 null。
        Map.Entry first = ((TreeMap<Integer, String>) treeMap).firstEntry();
        System.out.println("treeMap first entry,key= "+ first.getKey()+" ,value= "+ first.getValue());

        //返回此映射中当前第一个（最低）键。
        int firstKey = (int)((TreeMap<Integer, String>) treeMap).firstKey();
        System.out.println("treeMap first key="+firstKey);

        //返回一个键-值映射关系，它与小于等于给定键的最大键关联；如果不存在这样的键，则返回 null。
        Map.Entry floor = ((TreeMap<Integer, String>) treeMap).floorEntry(90);
        System.out.println("treeMap first entry,key= "+ floor.getKey()+" ,value= "+ floor.getValue());

        //返回小于等于给定键的最大键；如果不存在这样的键，则返回 null。
        int floorKey = (int)((TreeMap<Integer, String>) treeMap).floorKey(90);
        System.out.println("treeMap first key="+floorKey);

        //返回一个键-值映射关系，它与大于等于给定键的最小键关联；如果不存在这样的键，则返回 null。
        Map.Entry ceilingEntry = ((TreeMap<Integer, String>) treeMap).ceilingEntry(90);
        System.out.println("treeMap first entry,key= "+ ceilingEntry.getKey()+" ,value= "+ ceilingEntry.getValue());
        //返回大于等于给定键的最小键；如果不存在这样的键，则返回 null。
        int ceilingKey = (int)((TreeMap<Integer, String>) treeMap).ceilingKey(90);
        System.out.println("treeMap first key="+ceilingKey);

    }
}
