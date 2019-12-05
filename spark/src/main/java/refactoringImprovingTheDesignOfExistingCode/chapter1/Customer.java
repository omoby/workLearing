package refactoringImprovingTheDesignOfExistingCode.chapter1;


import java.util.Enumeration;
import java.util.Vector;

/**
 * @ClassName Customer
 * @Author zhangqx02
 * @Date 2019/12/3 16:40
 * @Description
 * 重构：改善既有代码的设计第一章的示例
 * Customer类用来表示顾客，就想其他类一样，他也有数据和对应的访问方法
 */

 class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String statement(){
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
        Enumeration rentalList = rentals.elements();
        String result = "Rental Record for "+getName()+"\n";
        while (rentalList.hasMoreElements()){
//            double thisAmount = 0;
            Rental each = (Rental) rentalList.nextElement();
//            thisAmount = each.getCharge();
//            thisAmount = amountFor(each);
//            switch (each.getMovie().getPriceCode()){
//                case Movie.REGULAR:
//                    thisAmount += 2;
//                    if (each.getDaysRented() >2){
//                        thisAmount += (each.getDaysRented() -2) * 1.5;
//                    }
//                    break;
//                case Movie.NEW_RELEASE:
//                    thisAmount += each.getDaysRented() * 2;
//                    break;
//                    case  Movie.CHILDRENS:
//                        thisAmount += 1.5;
//                        if (each.getDaysRented() > 3){
//                            thisAmount += (each.getDaysRented() -3) * 1.5;
//                        }
//                        break;
//                        default:
//            }
//            frequentRenterPoints += each.getFrequentRenterPoints();
//            frequentRenterPoints++;
//            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >1){
//                frequentRenterPoints++;
//            }
//            result += "\t" + each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount);
            result += "\t" + each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge());
//            totalAmount += thisAmount;
//            totalAmount += each.getCharge();
        }
        result += "Amount owed is "+ String.valueOf(getTotalCharge())+"\n";
//        result += "Amount owed is "+ String.valueOf(totalAmount)+"\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPointers()) + " frequent renter pointer";
        return result;
    }

    /**
     * 计算费用的方法
     * @param each
     * @return
     */
//    private double amountFor(Rental each){
//        double result = 0;
//        switch (each.getMovie().getPriceCode()){
//            case Movie.REGULAR:
//                result += 2;
//                if (each.getDaysRented() >2){
//                    result += (each.getDaysRented() -2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += each.getDaysRented() * 2;
//                break;
//            case  Movie.CHILDRENS:
//                result += 1.5;
//                if (each.getDaysRented() > 3){
//                    result += (each.getDaysRented() -3) * 1.5;
//                }
//                break;
//            default:
//        }
//        return result;
//        return each.getCharge();

//    }

    /**
     * 计算总费用
     * @return
     */
    private double getTotalCharge(){
        double result = 0;
        Enumeration rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()){
            Rental each = (Rental) rentalEnum.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 计算本次顾客获得的积分
     * @return
     */
    private int getTotalFrequentRenterPointers(){
        int result = 0;
        Enumeration rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()){
            Rental each = (Rental) rentalsEnum.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
