package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName SimpleRegex
 * @Author zhangqx02
 * @Date 2019/10/31 17:06
 * @Description
 *《精通正则表达式》第八章Java
 * 简短的匹配例子
 */

public class SimpleRegex {
    public static void main(String[] args){
//        simpleRegexTest();
//        findURL();
        replaceAll();

        String metric = "Thre normal celsiurs is from 36.3C to 40.1C. And if";
        celsiusToFahrenheit(metric);

        String text = "It's SO very RUDE to shuot!";
        upperCaseToLowerCase(text);
        lengthChangeUpperCaseToLowerCase(text);
        transparentBounds();
        test();
        }

    /**
     * 对正则表达式简短的匹配例子
     */
    private static void simpleRegexTest(){
        String myText = "this  is my 1st test 2st string";
//        String myRegex = "\\d+\\w+"; // 表示\d+\w+
        String myRegex = "\\w+";
        Pattern p = Pattern.compile(myRegex,Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);//不区分大小写的匹配
        Matcher m = p.matcher(myText);

        while (m.find()){
            String matchedText = m.group();
            int matchedFrom = m.start();
            int matchedTo = m.end();
            System.out.println("matched ["+matchedText+"]" +
                    " from "+matchedFrom+ " to "+matchedTo);
        }
//        else {
//            System.out.println("didn't match!");
//        }
    }

    /**
     * 给定一个URL字符串，找出URL的协议名('http'或是'https')，、主机名，以及可能出现的端口号
     */
    private static void findURL(){
        String url = "http://regex.info/blog";
        String regex = "(?x) ^(https?)://([^/:]+) (?:(\\d+))?";
        Matcher m = Pattern.compile(regex).matcher(url);
        if (m.find()){
            System.out.println("" +
                    "Overall ["+m.group() +"]" +
                    " (from "+m.start() +" to " +m.end() +" )\n" +
                    "Protocol ["+m.group(1) +"]" +
                    " (from "+m.start(1) +" to " +m.end(1) +")\n" +
                    "Hostname ["+m.group(2) +"]" +
                    " (from "+m.start(2) +" to " +m.end(2) +")\n" );
        }
        //group(3)可能来参与匹配，此处应小心对待
        if (m.group(3) == null){
            System.out.println("Not port; default of '80' is assumed");
        }else {
            System.out.println("Port is ["+m.group(3)+" ]" +
                    " (from "+m.start(3) + " to "+m.end()+")\n");
        }

    }

    /**
     * 简单查找-替换的例子
     */
    private static void replaceAll(){
        String text = "Before Java 1.5 was Java 1.4.2. After Java 1.5 was Java 1.6";
        String regex = "\\bJava\\s*1\\.5\\b";
        Matcher m = Pattern.compile(regex).matcher(text);
        String result = m.replaceAll("Java 5.0");
        System.out.println(result);

        String result1 = Pattern.compile("\\bJava\\s*1\\.([56])\\b").matcher(text).replaceAll("Java $1.0");
        System.out.println(result1);

    }

    /**
     * 查找-替换示范
     * @param m
     * @param replacement
     * @return
     */
    public static String replaceAll(Matcher m,String replacement){
        m.reset();//保证Matcher不受之前的影响
        StringBuffer result = new StringBuffer(); //用于替换生成的副本
        while (m.find()){
            m.appendReplacement(result,replacement);
        }
        m.appendTail(result);
        return  result.toString();//转换为String，然后返回
    }

    public static String replaceAllRegion(Matcher m,String replacement){
        Integer start = m.regionStart();
        Integer end = m.regionEnd();
        m.reset().region(start,end);//重置matcher,之后恢复region

        StringBuffer result = new StringBuffer();//生成用于替换的副本
        while (m.find()){
            m.appendReplacement(result, replacement);
        }
        m.appendTail(result);
        return result.toString();//转换为String之后进行返回

    }

    /**
     * 将metric变量中的摄氏温度转换为华氏温度
     */
    private static void celsiusToFahrenheit(String metric){
        //构建一个matcher，匹配"Meteric"变量中后面跟有"C"的数值
        //下面的正则表达式是:( \d+(?:\.\d*)?)C\b
        Matcher m = Pattern.compile("(\\d+(?:\\.\\d*)?)C\\b").matcher(metric);
        StringBuffer result = new StringBuffer();
        while (m.find()){
            float celsius = Float.parseFloat(m.group(1));//得到数值，转化为浮点数
            int fathrenheit = (int)(celsius * 9 /5 +32);
            m.appendReplacement(result, fathrenheit+"F");

        }
        m.appendTail(result);
        System.out.println(result.toString());

    }

    /**
     * 在StringBuiler中搜索大写单词，将他们替换为小写形式
     * @param text
     */
    private static void upperCaseToLowerCase(String text){
        StringBuilder builder = new StringBuilder(text);
        Matcher m = Pattern.compile("\\b[\\p{Lu}\\p{Lt}]+\\b").matcher(builder);
        while (m.find()){
            builder.replace(m.start(),m.end(),m.group().toLowerCase());
        }
        System.out.println(builder);
    }

    /**
     * 长度变化的替换
     * @param text
     */
    private static void lengthChangeUpperCaseToLowerCase(String text){
        StringBuilder builder = new StringBuilder(text);
         Matcher m =Pattern.compile("\\b[\\p{Lu}\\p{Lt}]+\\b").matcher(builder);
         int matchPointer = 0 ;
         while (m.find()){
             matchPointer = m.end();
             builder.replace(m.start(),m.end(),"<b>"+m.group().toLowerCase()+"</b>");
             matchPointer+=7;
         }
         System.out.println(builder);

    }

    private static void transparentBounds(){
        String regex = "\\bcar\\b";
        String text = "Madagascar is best seen by car or bike!";
        Matcher m = Pattern.compile(regex).matcher(text);
        m.region(7,text.length());
        m.useTransparentBounds(true);
        m.find();
        System.out.println("Matches starting at character "+m.start());
    }

    private static void test(){
         String regex = "^[\\d\\w_-]{4,6}$";
         String userName = "g671-_";
         Matcher m = Pattern.compile(regex).matcher(userName);
         if (m.find()){
             System.out.println(m.group());
         }
    }
}
