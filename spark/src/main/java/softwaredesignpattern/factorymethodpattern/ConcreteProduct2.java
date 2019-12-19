package softwaredesignpattern.factorymethodpattern;


/**
 * @ClassName ConcreteProduct2
 * @Author zhangqx02
 * @Date 2019/12/18 11:16
 * @Description
 * 具体产品2：实现抽象产品中的抽象方法
 */

public class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品2.。。");
    }
}
