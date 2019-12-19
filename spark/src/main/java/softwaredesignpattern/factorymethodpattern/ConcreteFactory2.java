package softwaredesignpattern.factorymethodpattern;


/**
 * @ClassName ConcreteFactory2
 * @Author zhangqx02
 * @Date 2019/12/18 11:18
 * @Description
 * 具体工厂2：实现产品的生产抽象方法
 */

public class ConcreteFactory2  implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2：生产产品-》2");
        return new ConcreteProduct2();
    }
}
