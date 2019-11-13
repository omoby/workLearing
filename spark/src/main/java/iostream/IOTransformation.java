package iostream;


import java.io.UnsupportedEncodingException;

/**
 * @ClassName IOTransformation
 * @Author zhangqx02
 * @Date 2019/11/4 11:50
 * @Description
 * IO流转换流的字符编码
 */

public class IOTransformation {
    public static void main(String[] args){
        //编码解码1：默认编码
        String str1 = "你好";
        byte[] buf1 = str1.getBytes();//默认解码：Unicode，四个字节

        //编码解码2:指定编码
        String str2 = "你好";
        byte[] buf2 =  null;
        try {
            buf2 = str2.getBytes("UTF-8"); //指定编码：UTF-8 六个字节
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        //编码解码3:编码正确解码错误
        String str3 = "你好";
        byte[] buf3 = null;
        try {
            buf3 =str3.getBytes("GBK");//指定编码:GBK 四个字节
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String str31 = null;
        try{
            str31 = new String(buf3,"ISO8859-1");//解码错误
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        //编码解码4:编码错误解码正确
        String str4 = "你好";
        byte[] buf4 = null;
        try{
            buf4 = str4.getBytes("ISO8859-1");//错误编码
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
         String str41 = null;
        try{
            str41 = new String(buf4,"GBK");//正确编码，读不出来
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        //编码解码5:编码正确，但是解码错误，怎么办能
        String str5 = "你好";
        byte[] buf5 = null;
        try{
            buf5 = str5.getBytes("GBK");//正确编码
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String str6 = null;
        try{
            str6 = new String(buf5,"ISO8859-1");//错误解码，读不出来
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        byte[] buf6 = null;
        try{
            buf6 = str6.getBytes("ISO8859-1");//再错误编码
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String str7 = null;
        try{
            str7 = new String(buf6,"GBK");//在正确解码，这样就可以读出来
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

    }
}
