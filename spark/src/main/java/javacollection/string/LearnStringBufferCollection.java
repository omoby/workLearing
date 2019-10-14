package javacollection.string;


/**
 * @ClassName LearnStringBufferCollection
 * @Author zhangqx02
 * @Date 2019/9/4 19:47
 * @Description
 *
 *将StringBuffer作为集合的一部分，系统的学习StringBuffer的常用方法
 *
 * 常用构造方法
 * StringBuffer()
 *           构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符。
 * StringBuffer(CharSequence seq)
 *           public java.lang.StringBuilder(CharSequence seq) 构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符。
 * StringBuffer(int capacity)
 *           构造一个不带字符，但具有指定初始容量的字符串缓冲区。
 * StringBuffer(String str)
 *           构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容。
 */

public class LearnStringBufferCollection {
    public static void main(String[] args){

        createStringBuffer();
        createStringBuffer2();
        createStringBuffer3();
        addData();
        deleteData();
        replaceData();
        retriveData();
        getLengthAndCapacity();

        getIndexOf();
        subStringMeth();
        reverseMethod();
        stringConversionStringBuffer();
    }

    /**
     * 构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符。
     *
     */
    public static void createStringBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("Java is powerful!");
        System.out.println("StringBuffer构造函数不带参数：");
        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append('a');
        stringBuffer.append(" ");
        stringBuffer.append(100);
        stringBuffer.append(stringBuilder);
        System.out.println(stringBuffer);
    }

    /**
     * 构造一个不带任何字符的字符串生成器，其初始容量由 capacity 参数指定。
     */
    public static void createStringBuffer2(){
        StringBuffer stringBuffer = new StringBuffer(10);
        System.out.println("StringBuffer构造函数带一个容量参数：");
        int capacity = stringBuffer.capacity();
        for (int i = 0; i < 20; i++){
            if (stringBuffer.length() > capacity){
                break;
            }
            stringBuffer.append(i);
            stringBuffer.append("_");
        }
        System.out.println(stringBuffer);
        System.out.println("length: "+ stringBuffer.length());
        System.out.println("capacity: "+stringBuffer.capacity());

    }

    /**
     * 构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容。该字符串的初始容量为 16 加上字符串参数的长度。
     */
    public static void createStringBuffer3(){
        StringBuffer stringBuffer = new StringBuffer("Hello Java!");
        System.out.println("StringBuffer构造函数带一个字符串参数：");
        System.out.println(stringBuffer);
        System.out.println("length: "+ stringBuffer.length());
        System.out.println("capacity: "+stringBuffer.capacity());
    }

    /**
     * StringBuffer中添加数据的方法
     */
    public static void addData(){
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("向StringBuffer中添加数据：");

        System.out.println("stringBuffer: "+stringBuffer);
        //将指定的字符串追加到此字符序列
        stringBuffer.append("Hello Java!");
        System.out.println("Call append(): "+ stringBuffer);

        //   将字符串插入此字符序列中。
        stringBuffer.insert(0, "Bigdata ");
        System.out.println("Call insert(): "+ stringBuffer);
    }

    /**
     * StringBuffer中删除数据方法
     */
    public static void deleteData(){
        StringBuffer stringBuffer = new StringBuffer("Java is very powerful");
        System.out.println("从StringBuffer中删除数据：");

        System.out.println("stringBuffer: "+stringBuffer);

        stringBuffer.deleteCharAt(1);
        System.out.println("Call deleteCharAt(): "+stringBuffer);

        stringBuffer.delete(0, stringBuffer.length());
        System.out.println("Call delete(): "+ stringBuffer);

        System.out.println("stringBuffer: "+stringBuffer +"\n capacity:"+stringBuffer.capacity()+"\n length: "+stringBuffer.length());

    }

    /**
     * StringBuffer中的替换方法
     */
    public static void replaceData(){
        StringBuffer stringBuffer = new StringBuffer("Java is very powerful!");

        System.out.println("从StringBuffer中替換数据");
        System.out.println("stringBuffer: "+stringBuffer);

        stringBuffer.replace(0, 4, "Scala");
        System.out.println("Call replace(): "+stringBuffer);
    }

    /**
     * StringBuffer中获取字符的方法
     */
    public static void retriveData(){
        StringBuffer stringBuffer = new StringBuffer("Java is powerful!");
        System.out.println("从StringBuffer中获取数据");
        System.out.println("stringBuffer: "+stringBuffer);

        char ch = stringBuffer.charAt(1);
        System.out.println("Call charAt(): "+ch);
    }

    /**
     * 获取StringBuffer的长度和容量
     */
    public static void getLengthAndCapacity(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Java is very  useful language!");

        System.out.println("从StringBuffer中获取长度和容量：");
        System.out.println("stringBuffer: "+stringBuffer);

        int length = stringBuffer.length();
        int capacity = stringBuffer.capacity();
        System.out.println("The length: "+ length);
        System.out.println("The capacity: "+capacity);

    }
    /**
     * 获取StringBuffer中数据的位置
     */
    public static void getIndexOf(){
        StringBuffer  stringBuffer = new StringBuffer("Java is a very useful language!");
        System.out.println("从StringBuffer中获取数据位置");
        System.out.println("stringBuffer: "+stringBuffer);

        int index1 = stringBuffer.indexOf("a");
        System.out.println("Call indexOf(String): "+index1);

        int index2 = stringBuffer.indexOf("a", 10);
        System.out.println("Call indexOf(String,StartIndex): " +index2);

        int lastIndex = stringBuffer.lastIndexOf("a");
        System.out.println("Call lastIndexOf(String): "+ lastIndex);

        int lastIndex2 = stringBuffer.lastIndexOf("a",20);
        System.out.println("Call lastIndexOf(String,fromStart): "+ lastIndex2);
    }

    /**
     * 获取StringBuffer中子串
     */
    public static void subStringMeth(){
        StringBuffer  stringBuffer = new StringBuffer("Java is a very useful language!");
        System.out.println("从StringBuffer中获取子集");
        System.out.println("stringBuffer: "+stringBuffer);

        String sub = stringBuffer.substring(10);
        System.out.println("Call substring(start): "+sub);

        String sub2 = stringBuffer.substring(10,20);
        System.out.println("Call substring(start,end): "+sub2);
    }

    /**
     * 获取StringBuffer翻转
     */

    public static void reverseMethod(){
        StringBuffer  stringBuffer = new StringBuffer("Java is a very useful language!");
        System.out.println("从StringBuffer中获取子集");
        System.out.println("stringBuffer: "+stringBuffer);
        stringBuffer.reverse();
        System.out.println("Call reverse(): "+ stringBuffer);
    }

    /**
     * String和StringBuffer相互转换
     */
    public static void stringConversionStringBuffer(){
        String string = "Java is useful!";
        System.out.println("String 和StringBuff相互转换：");
        System.out.println("string: "+ string);

        StringBuffer stringBuffer = new StringBuffer(string);
        System.out.println("stringBuffer: "+stringBuffer.toString());

    }
}
