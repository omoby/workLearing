/**
 * @ClassName JavaEnum
 * @Author zhangqx02
 * @Date 2019/8/15 10:06
 * @Description
 * java枚举类
 */

public enum JavaEnum {

    ORACLE(0, "oracle"),
    MYSQL(1, "mysql"),
    SQLSERVER(2, "sqlserver"),
    POSTGRESQL(3, "postgresql"),
    HDFS(4, "hdfs"),
    HBASE(5, "hbase"),
    MONGODB(6, "mongodb"),
    FTP(7, "ftp"),
    TXT(8, "txt"),
    DB2(9,"db2"),
    HIVE(10,"hive"),
    ES(11,"es"),
    KAFKA(12,"kafka");

    private Integer code;
    private String name;

    JavaEnum(Integer code, String name) {
        this.code = code;
        this.name = name;

    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;

    }

    public static JavaEnum getByName(String code){
        JavaEnum[] enums = JavaEnum.values();
        for(JavaEnum enumt: enums) {
            if(enumt.getName().equalsIgnoreCase(code)) {
                return enumt;
            }
        }
        return null;
    }

    public static JavaEnum getById(int id) {
        JavaEnum[] enums = JavaEnum.values(); //.values()方法返回枚举常量的集合
        for(JavaEnum enumt: enums) {
            if(enumt.getCode().intValue() == id) {
                return enumt;
            }
        }
        return null;
    }

}
