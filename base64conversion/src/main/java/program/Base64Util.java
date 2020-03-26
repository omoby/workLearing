package program;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @ClassName Base64Util
 * @Author zhangqx02
 * @Date 2020/3/26 10:34
 * @Description
 * Base64加密/解密工具类
 */
public class Base64Util {

    final static Base64.Encoder encoder = Base64.getEncoder();
    final static Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 给字符串加密
     * @param text
     * @return
     */
    public static String encode(String text) {

        try {
            return encoder.encodeToString(text.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将加密后的字符串进行解密
     * @param encodedText
     * @return
     */
    public static String decode(String encodedText) {
        try {
            return new String(decoder.decode(encodedText),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        String username = "烛台";
        String password = "坐姿矫正器";

        // 加密
        System.out.println("====  [加密后] 用户名/密码  =====");
        System.out.println(Base64Util.encode(username));
        System.out.println(Base64Util.encode(password));

        // 解密
        System.out.println("\n====  [解密后] 用户名/密码  =====");
        System.out.println(Base64Util.decode(Base64Util.encode(username)));
        System.out.println(Base64Util.decode(Base64Util.encode(password)));
    }
}