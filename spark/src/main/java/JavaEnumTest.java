import org.codehaus.janino.Java;

/**
 * @ClassName JavaEnumTest
 * @Author zhangqx02
 * @Date 2019/8/15 10:05
 * @Description
 * java枚举类
 */

public class JavaEnumTest {
    public static void main(String[] args){
//        testGetById();
        testValues();
    }

    public static void testGetById(){
        JavaEnum javaEnum = JavaEnum.getById(1);
        String name = javaEnum.getName();
        int code = javaEnum.getCode();
        System.out.println("Name: "+ name + " Code: "+code);
        System.out.println(javaEnum.toString());
    }

    public static void testValues(){
        JavaEnum[] javaEnums = JavaEnum.values();
        for (JavaEnum javaEnum : javaEnums) {
            System.out.println(javaEnum.toString()); //toString()方法返回枚举常量的名称
            System.out.println("  Name: "+javaEnum.name()+ " Ordinal: " + javaEnum.ordinal());
            System.out.println("  getName(): "+javaEnum.getName()+ " getCode(): " + javaEnum.getCode());
            System.out.println();
        }
    }

}
