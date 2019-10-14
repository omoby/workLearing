package test;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Author zhangqx02
 * @Date 2019/10/9 13:43
 * @Description
 */

public class MapTest {
    public  static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        String key = "hello";
        String value = map.get(key);
        System.out.println(value);
        String str1 = "DataTest.result_of_select_query";
        String str2 = "DataTest.result_of_select_query_s";
        String str3 = "DataTest.result_of_select_query_m";
        System.out.println(str1.equals(str2));
    }
}
