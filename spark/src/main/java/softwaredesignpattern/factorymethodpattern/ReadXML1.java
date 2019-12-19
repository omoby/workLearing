package softwaredesignpattern.factorymethodpattern;


import org.objectweb.asm.ClassAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import java.io.File;

/**
 * @ClassName ReadXML1
 * @Author zhangqx02
 * @Date 2019/12/18 11:28
 * @Description
 */

public class ReadXML1 {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getObject(){
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\MyFile\\workLearning\\spark\\src\\main\\java\\softwaredesignpattern\\factorymethod\\config.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "softwaredesignpattern.factorymethod."+classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
