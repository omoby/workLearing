package refactoringImprovingTheDesignOfExistingCode.chapter1;


/**
 * @ClassName Movie
 * @Author zhangqx02
 * @Date 2019/12/3 16:31
 * @Description
 * 重构：改善既有代码的设计第一章的示例
 * Movie只是一个简单的纯数据类
 */

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title ;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    /**
     * 不同类型的电影的租金计算方式
     * @param daysRented
     * @return
     */
    double getCharge(int daysRented){
        double result = 0;
        switch (getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2){
                    result += (daysRented -2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3){
                    result += (daysRented -3) * 1.5;
                }
                break;
                default:
        }
        return result;
    }

    /**
     * 计算每一部影片的积分
     * @param daysRented
     * @return
     */
    int getFrequentRenterPoints(int daysRented){
        if ((getPriceCode() == Movie.NEW_RELEASE) &&  daysRented >1){
            return 2;
        }else {
            return 1;
        }
    }
}
