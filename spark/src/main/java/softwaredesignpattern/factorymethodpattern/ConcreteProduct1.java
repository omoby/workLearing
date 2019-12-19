package softwaredesignpattern.factorymethodpattern;


/**
 * @ClassName ConcreteProduct1
 * @Author zhangqx02
 * @Date 2019/12/18 11:16
 * @Description
 * 具体产品1：实现抽象产品中的抽象方法
 */

public class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品1。。。");
    }
}
