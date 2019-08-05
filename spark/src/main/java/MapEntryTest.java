import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapEntryTest
 * @Author zhangqx02
 * @Date 2019/8/5 15:13
 * @Description
 *
 * boolean    equals(Object o)
 *           比较指定对象与此项的相等性。
 *
 *  K	getKey()
 *           返回与此项对应的键。
 *
 *  V	getValue()
 *           返回与此项对应的值。
 *
 *  int	hashCode()
 *           返回此映射项的哈希码值。
 *
 *  V	setValue(V value)
 *           用指定的值替换与此项对应的值（可选操作）。
 */

public class MapEntryTest {
    public static void main(String[] agrs){
        Map<String,Integer> map = new HashMap<>();
        map.put("Spark",100);
        map.put("Hadoop",90);
        map.put("Flink",98);
        map.put("Hive",90);
        map.put("Hbase",88);
        System.out.println("map contains: "+ map.toString());
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            String key = entry.getKey();
            if ("Hadoop".equals(key)){
                Map<String,Integer> map1 = new HashMap<>();
                map1.put("Hadoop",90);
                for (Map.Entry<String,Integer> entry1 :map1.entrySet()){
                    boolean isEqual = entry.equals(entry1);
                    System.out.println("isEquals : "+ isEqual );
                }

            }
            int value = entry.getValue();
            int hashCode = entry.hashCode();
            System.out.println("key = "+key+" , value = "+ value+" , hashCode = "+ hashCode);
            entry.setValue(value-1);
        }
        System.out.println("Now map contains: "+ map.toString());

    }
}
