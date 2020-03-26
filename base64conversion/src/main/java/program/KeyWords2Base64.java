package program;

/**
 * @ClassName KeyWords2Base64
 * @Author zhangqx02
 * @Date 2020/3/26 12:11
 * @Description
 * 加密前后数据对象
 */

public class KeyWords2Base64{
    private String keyword1 ;
    private String keyword2;

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    @Override
    public String toString() {
        return "KeyWords2Base64{" +
                "keyword1='" + keyword1 + '\'' +
                ", keyword2='" + keyword2 + '\'' +
                '}';
    }
}