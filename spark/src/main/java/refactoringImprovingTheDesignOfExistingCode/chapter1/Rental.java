package refactoringImprovingTheDesignOfExistingCode.chapter1;


/**
 * @ClassName Rental
 * @Author zhangqx02
 * @Date 2019/12/3 16:36
 * @Description
 * 重构：改善既有代码的设计第一章的示例
 * Rental表示每一个顾客租了一部影片
 */

 class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    /**
     * 计算费用的方法
     * @return
     */
    double getCharge(){
        return movie.getCharge(daysRented);
//        double result = 0;
//        switch (getMovie().getPriceCode()){
//            case Movie.REGULAR:
//                result += 2;
//                if (getDaysRented() >2){
//                    result += (getDaysRented() -2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += getDaysRented() * 2;
//                break;
//            case  Movie.CHILDRENS:
//                result += 1.5;
//                if (getDaysRented() > 3){
//                    result += (getDaysRented() -3) * 1.5;
//                }
//                break;
//            default:
//        }
//        return result;
    }

    /**
     * 计算积分
     * @return
     */
    int getFrequentRenterPoints(){
        return movie.getFrequentRenterPoints(daysRented);
//        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() >1){
//            return 2;
//        }else {
//            return 1;
//        }
    }
}
