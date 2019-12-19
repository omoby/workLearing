package softwaredesignpattern.factorymethodpattern;


/**
 * @ClassName ConcreteFactory1
 * @Author zhangqx02
 * @Date 2019/12/18 11:17
 * @Description
 * 具体工厂1：实现工厂生产产品的抽象方法
 */

public class ConcreteFactory1  implements AbstractFactory{
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1：生产具体产品-》1");
        return new ConcreteProduct1();
}
}
