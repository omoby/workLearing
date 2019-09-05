package javacollection;


/**
 * @ClassName LearnStringCollection
 * @Author zhangqx02
 * @Date 2019/9/4 14:28
 * @Description
 * 将String类作为集合的一部分，系统的学习字符串各种操作
 * String常用构造方法
 * public String():无参构造
 * public String(byte[] bytes):将字节数组转换成字符串
 * public String(byte[] bytes,int offset,int length):将字节数组的一部分转换成字符串
 * public String(char[] value):将字符数组转换成字符串
 * public String(char[] value,int offset,int count):将字符数组的一部分转换成字符串
 * public String(String original):将一个常量转换字符串:String 是不可变的，所以无需使用此构造方法
 * 以及字符串中的常用方法
 */

public class LearnStringCollection {
    public static void main(String[] args){
        string1();
        string2();
        string3();
        string4();
        string5();
        string6();
        string7();
        booleanMethod();
        acquisitionMethod();
        converionMethod();
        replaceMethod();
        splitMethod();
        trimMethod();
        compareMethod();
    }

    /**
     * String()无参构造方法
     */
    public static void string1(){
        String string = new String();
        string = "hello";
        System.out.println("无参构造方法：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");

    }

    /**
     * 参构造方法传入一个字节数组作为参数
     */
    public static void string2(){
        byte[] bys = {97,98,99,100,101};
        String string = new String(bys);
        System.out.println("参构造方法传入一个字节数组作为参数：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }

    /**
     * 把字节数组的一部分转化为一个字符串
     */
    public static void string3(){
        byte[] bys = {97,98,99,100,101};
        String string = new String(bys,1,2);
        System.out.println("参构造方法把数组的一部分转化为一个字符串：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }
    /**
     *把一个字符数组作为参数
     */
    public static void string4(){
        char[] chs = {'a','b','c','d','e'};
        String string = new String(chs);
        System.out.println("参构造方法把字符数组转化为一个字符串：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }
    /**
     * 把字符数组的一部分转换为一个字符串
     */
    public static void string5(){
        char[] chs = {'a','b','c','d','e'};
        String string  = new String(chs,1,2);
        System.out.println("参构造方法把字符数组的一部分转化为一个字符串：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }

    /**
     * 把一个字符串传递过来作为参数
     */

    public static void string6(){
        String s = "Hello Java";
        String string = new String(s);
        System.out.println("参构造方法把一个字符串传递过来作为参数：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }

    /**
     * 直接把字符串常量赋值给字符串引用对象(最常用)
     */
    public static void string7(){
        String string = "Hello Java";
        System.out.println("直接把字符串常量赋值给字符串引用对象(最常用)：");
        System.out.println("string:"+string);
        System.out.println("------------------------------");
    }

    /**
     * 字符串一些常用的boolean方法
     */
    public static void booleanMethod(){
        String string1 = "\"Hello Java\"";
        String string2 = "\"Hello BigData\"";
        //String string3 = "";
        String string3 = new String();

        System.out.println("stirng的判断方法：");
        System.out.println("string1: "+string1);
        System.out.println("string2: "+string2);
        System.out.println("string3: "+ string3);

        boolean isEquals = string1.equals(string2);
        System.out.println("string1 equals string2: "+isEquals);

        boolean isContains = string1.contains("Java");
        System.out.println("string1 contains 'Java': "+ isContains);

        boolean isStartWith = string2.startsWith("\"");
        System.out.println("string2 start with \": "+isStartWith);

        boolean isEndWith = string2.endsWith("\"");
        System.out.println("string2 end with \": "+ isEndWith);

        boolean isEmpty1 = string2.isEmpty();
        System.out.println("string2 is empty； "+ isEmpty1);

        boolean isEmpty2 = string3.isEmpty();
        System.out.println("string3 is empty； "+ isEmpty2);

    }

    /**
     * 字符串中获取的方法
     */
    public static void acquisitionMethod(){
        char[] chs = {'a','b','c','d','e','f','g','a','b'};
        String string = new String(chs);

        System.out.println("字符串中获取的方法：");
        System.out.println("string: "+ string);

        int length = string.length();
        System.out.println("\""+string+"\" length: "+ length);

        char firstChar = string.charAt(0);
        char lastChar = string.charAt(length-1);
        System.out.println("\""+string+"\" first char: "+ firstChar + " last char: "+lastChar);

        int indexOfb = string.indexOf(98);
        System.out.println("The index of b : "+ indexOfb);
        int indexOfc = string.indexOf('c');
        System.out.println("The index of character c: "+ indexOfc);

        int indexOfStringbc = string.indexOf("bc");
        System.out.println("The index of String bc: "+ indexOfStringbc);

        int lastIndexOfa = string.lastIndexOf(97);
        System.out.println("The last index of a: "+ lastIndexOfa);

        int lastIndexOfStringab = string.lastIndexOf("ab");
        System.out.println("The last index of String ab: "+ lastIndexOfStringab);

        String subString = string.substring(1);
        System.out.println("The substring of \""+string+"\" from index of 1: "+subString);

        String subString2 = string.substring(1,3);
        System.out.println("The substring of \""+ string +"\" from index 1 to 3: "+subString2);


    }

    /**
     * 字符串中转换的方法
     */
    public static void converionMethod(){
        String string1 = new String("ABCD");
        String string2 = "efgh";
        char[] chs = {'i','j','k','l','m'};

        System.out.println("字符串中转换的方法：");
        System.out.println("string1: " + string1);
        System.out.println("string2: "+ string2);

        byte[] string1ToBytes = string1.getBytes();
        System.out.print("string1 to bytes: ");
        for (byte b: string1ToBytes){
            System.out.print(" "+ b);
        }
        System.out.println();

        char[] copyCharArray = new char[5];
        string1.getChars(1, 4, copyCharArray, 1);
        System.out.print("string1 getChars: ");
        for (char c : copyCharArray){
            if (c==0){
                System.out.print(" "+ null);
            }else {
                System.out.print(" "+ c);
            }

        }
        System.out.println();

        char[] stringToArray = string1.toCharArray();
        System.out.print("string1 toCharArray: ");
        for (char c: stringToArray) {
            System.out.print(" "+ c);
        }
        System.out.println();

        String string3 = "";
        string3 = string3.copyValueOf(chs);
        System.out.println("string3 copyValueOf: "+string3);

        String string4 = "";
        string4 = string4.copyValueOf(chs,1,3);
        System.out.println("string4 copyValueOf: "+string4);

        String string5 = String.valueOf(chs);
        System.out.println("ValueOf: " + string5);

        String string6 = string1.toLowerCase();
        System.out.println("string1 to Lower Case: "+ string6);

        String string7 = string2.toUpperCase();
        System.out.println("string2 to Upper Case: "+ string7);

        String string8 = string1.concat(string2);
        System.out.println("string1 concat string2: "+ string8);


    }

    /**
     * 字符串中的替换方法
     */

    public static void replaceMethod(){
        String str1 = new String("Java is a powerful language");
        String str2 = "Java is very powerful,and is very useful";


        System.out.println("字符串中的替换方法：");
        System.out.println("str1: "+ str1);
        System.out.println("str2: "+ str2);

        String replaceChar = str1.replace('a', 'b');
        System.out.println("str1 uses replace method: "+ replaceChar);

        String replaceString = str2.replace("is", "IS");
        System.out.println("str2 uses replace method: "+ replaceString);

    }

    /**
     * 字符串中的切割方法
     */
    public static void splitMethod() {
        String str = "Java is a powerful language";
        System.out.println("字符串中的分割方法：");
        System.out.println("str: " + str);
        String[] splited = str.split(" ");
        System.out.print("切割后： ");
        for (String elem: splited) {
            System.out.print(" \"" + elem+"\"");

        }

        System.out.println();
        String[] splitedLimited = str.split(" ",2);
        System.out.print("splitedLimited: ");
        for (String elem: splitedLimited
             ) {
            System.out.print(" \"" + elem+"\"");

        }

        System.out.println();
    }

    /**
     * 字符串忽略前后空白符
     */
    public static void trimMethod(){
        String str = " Hell World ";
        System.out.println("字符串忽略前后空白符： ");
        String str1 = str.replace(" ", "_");
        System.out.println("str: "+ str1);
        String strTrim = str.trim().replace(' ', '_');
        System.out.println("strTrim： "+ strTrim);
    }


    /**
     * 字符串比较方法
     */

    public static void compareMethod(){
        String str1 = "abcd";
        String str2 = "ABCD";

        System.out.println("字符串比较方法： ");
        int compared = str1.compareTo(str2);
        System.out.println("str1 compareTo str2: "+ compared);

        int compared2 = str1.compareToIgnoreCase(str2);
        System.out.println("str1 compareToIgnoreCase: "+ compared2);
    }
}
