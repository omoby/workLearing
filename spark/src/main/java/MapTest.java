import org.spark_project.dmg.pmml.SeasonalTrendDecomposition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapTest
 * @Author zhangqx02
 * @Date 2019/8/5 8:27
 * @Description
 */

public class MapTest {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("Spark",100);
        map.put("Hadoop",90);
        map.put("Flink",98);
        map.put("Hive",90);
        System.out.println("map is "+ map.toString());
//        clearMethod(map);
//        containsKeyMethod(map);
//        containsValuesMethod(map);
//        entrySetMethod(map);
//        equalsMethod(map);
//        getMethod(map);
//        hashCodeMethod(map);
//        isEmptyMethod(map);
//        keySetMethod(map);
//        putMethod(map);
//        putAllMethod(map);
//        removeMethod(map);
        valuesMethod(map);
    }

    /**
     * 测试Map的clear方法 \n
     * void clear( )
     *从此映射中移除所有映射关系（可选操作）。
     * @param map
     *
     */
    public static void clearMethod(Map<String,Integer> map){
        System.out.println("In clearMethod,before clear method execute,map size: "+ map.size());
        map.clear();
        System.out.println("clearMethod,map size: "+ map.size());
    }

    /**
     * 测试Map中的containsKey方法
     * @param map
     *
     * boolean containsKey(Object k)
     * 如果此映射包含指定键的映射关系，则返回 true。
     */
    public static void containsKeyMethod(Map<String,Integer> map){
        String[] keys = {"Spark","Hadoop","Flink","Hive","Hbase"};
        for (String key:keys){
            boolean isContain = map.containsKey(key);
            System.out.println("In containsKeyMethod ,map contains ["+ key+ "] is ["+ isContain+" ]");
        }
    }

    /**
     * 测试containsValue方法
     * @param map
     *
     * 	boolean containsValue(Object v)
     * 如果此映射将一个或多个键映射到指定值，则返回 true。
     */
    public  static void containsValuesMethod(Map<String,Integer> map){
        Integer[] scores = {100,90,80,99};
        for (Integer integer: scores){
            boolean isContainValue = map.containsValue(integer);
            if (isContainValue){
                System.out.println("In containsValueMethod,value is : "+ integer + " and key is " + isContainValue);
            }else {
                System.out.println("In containsValueMethod, not contains value: "+ integer);
            }
        }
    }
    /**
     * 测试Map的keySet方法
     * @param map
     *
     * 	Set entrySet( )
     * 返回此映射中包含的映射关系的 Set 视图。
     */

    public static void entrySetMethod(Map<String,Integer> map){
        for (Map.Entry<String,Integer> keyset:map.entrySet()){
            System.out.println("In entrySetMethod: "+ keyset.toString());
        }
    }

    /**
     * 测试equals方法
     * @param map
     * boolean equals(Object obj)
     * 比较指定的对象与此映射是否相等。
     */
    public static void equalsMethod(Map<String,Integer> map){
        Map<String,Integer> mapTest = new HashMap<>();
        mapTest.put("Zookeeper",70);
        mapTest.put("Yarn",80);

        Map<String,Integer> mapTest2 = new HashMap<>();
        mapTest2.put("Spark",100);
        mapTest2.put("Hadoop",90);
        mapTest2.put("Flink",98);
        mapTest2.put("Hive",90);
        boolean isEquals = map.equals(mapTest);

        System.out.println("In equalsMethod, object "+ mapTest.toString()+" is equals  "+map.toString() +" is "+ isEquals);

        boolean isEquals2 = map.equals(mapTest2);
        System.out.println("In equalsMethod, object "+ mapTest2.toString()+" is equals  "+map.toString() +" is "+ isEquals);

    }

    /**
     * 测试get方法
     * @param map
     * 	Object get(Object k)
     * 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
     */

    public static void getMethod(Map<String,Integer> map){
        String[] keys = {"Spark","Hadoop","Flink","Hive","Hbase"};
        for (String key : keys){
            System.out.println("In getMethod, key is "+ key+" and value is "+ map.get(key));
        }
    }

    /**
     * 测试hashCode方法
     * @param map
     * int hashCode( )
     * 返回此映射的哈希码值。
     */
    public static void hashCodeMethod(Map<String,Integer> map ){
        System.out.println("In hashCodeMethod, map hashCode is "+ map.hashCode());
    }

    /**
     * 测试isEmpty方法
     * @param map
     * 	boolean isEmpty( )
     * 如果此映射未包含键-值映射关系，则返回 true。
     *
     */
    public static void isEmptyMethod(Map<String,Integer > map){
        System.out.println("In isEmptyMethod, before execute clear method, map is empty "+ map.isEmpty());
        map.clear();
        System.out.println("In isEmptyMethod, after execute clear method, map is empty "+ map.isEmpty());
    }

    /**
     * 测试keySet
     * @param map
     * Set keySet( )
     * 返回此映射中包含的键的 Set 视图。
     */
    public static void keySetMethod(Map<String,Integer> map){
        Set<String> keys = map.keySet();
        System.out.println("In keySetMethod,keys set is " + keys.toString());
    }

    /**
     * 测试put方法
     * @param map
     * Object put(Object k, Object v)
     * 将指定的值与此映射中的指定键关联（可选操作）。
     */
    public static void putMethod(Map<String,Integer> map){
        System.out.println("In putMethod, before put execute mehtod map is "+ map.toString());
        map.put("Kylin",99);
        System.out.println("In putMethod, after put execute mehtod map is "+ map.toString());

    }

    /**
     * 	测试putAll方法
     * @param map
     *
     * void putAll(Map m)
     * 从指定映射中将所有映射关系复制到此映射中（可选操作）。
     */

    public static void putAllMethod(Map<String,Integer> map){
        Map<String,Integer> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println("In putMethod,  map1 is "+ map1.toString());

    }

    /**
     *测试remove方法
     * @param map
    *Object remove(Object k)
    *如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
     */

    public static void removeMethod(Map<String,Integer> map){
        String removeKey = "Hadoop";
        System.out.println("In putMethod, before remove execute mehtod map is "+ map.toString());
        map.remove(removeKey);
        System.out.println("In putMethod, after remove execute mehtod map is "+ map.toString());


    }

    /**
     * 测试values方法
     * @param map
     * Collection values( )
     * 返回此映射中包含的值的 Collection 视图。
     */
    public static void valuesMethod(Map<String,Integer > map){
        System.out.println("In putMethod,  map  values is "+ map.values());
    }
}
