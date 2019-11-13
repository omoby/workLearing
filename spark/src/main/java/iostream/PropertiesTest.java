package iostream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName PropertiesTest
 * @Author zhangqx02
 * @Date 2019/11/4 13:45
 * @Description
 * Properties示例代码
 */

public class PropertiesTest {

    public static void main(String[] args) throws IOException{
        show();
        setPropertyFile();
    }

    private static void show(){
        Properties prop = new Properties();
        prop.setProperty("张三","26");
        prop.setProperty("李四", "30");
        prop.setProperty("王五", "35");
        System.out.println(prop);
        String value = prop.getProperty("张三");
        System.out.println(value);

        Set<String> keys = prop.stringPropertyNames();
        for (String key:keys){
            System.out.println(key +"::"+prop.getProperty(key));
        }
    }

    /**
     * 需求：
     * 记录运用程序的使用次数，如果使用次数一道，则提示用户注册
     * 思路:
     * 第一次使用时创建一个配置文件用于记录使用次数
     * 每次使用都加载配置文件，并先判断一使用次数
     * 每次使用完使用次数加1，写入配置我文件
     * @throws IOException
     */
    private static void setPropertyFile() throws IOException{
        Properties prop = new Properties();//定义Properties，用来和IO流结合
        File file = new File("D:\\MyFile\\workLearning\\spark\\src\\files\\propertyFile.txt"); //配置文件
        if (!file.exists()){
            file.createNewFile();//如果配置文件不存在则创建文件(用于第一次使用时创建文件)
        }
        FileInputStream fis = new FileInputStream(file);//定义字节读取流，读取配置文件中总的使用次数
        prop.load(fis);//载入流，以获取文件中配置的键值对
        int count = 0;//定义使用次数
        String countValue = prop.getProperty("time");//通过键获取值
        if (countValue != null){
            count = Integer.parseInt(countValue);//将字符串转换成数字次数
            if (count > 3){
                System.out.println("您使用次数已达到，继续使用请注册!");
                return;
            }
        }
        count++;//如果使用次数未达到则次数加1
        prop.setProperty("time", count+"");//配置新的键值对
        FileWriter fos = new FileWriter(file);
        prop.store(fos, "这是运用程序使用次数的配置文件");//将新的键值对写入文件
        fis.close();
        fos.close();
    }
}
