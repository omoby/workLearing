package softwaredesignpattern.factorymethodpattern;


/**
 * @ClassName AbstractFactoryTest
 * @Author zhangqx02
 * @Date 2019/12/18 11:18
 * @Description
 */

public class AbstractFactoryTest {
    public static void main(String[] args){
        try{
            Product a;
            AbstractFactory af;
            af =(AbstractFactory)ReadXML1.getObject();
            a = af.newProduct();
            a.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
