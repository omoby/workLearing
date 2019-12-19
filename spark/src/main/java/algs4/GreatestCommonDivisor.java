package algs4;


import java.util.Stack;

/**
 * @ClassName GreatestCommonDivisor
 * @Author zhangqx02
 * @Date 2019/12/19 9:38
 * @Description
 */

public class GreatestCommonDivisor {
    public static void main(String[] args){
        int a = 12;
        int b = 44;
//        int gcd = primeGcd(a,b);
//        int gcd = euclideanGcd(a,b);
//        int gcd = lossGcd(a,b);
        int gcd = shortGcd(a,b);
        System.out.println("("+a +","+b +")="+gcd);
    }
    /**
     * 质因数分解法
     * 质因数分解
     * 质因数分解(9张)
     * 质因数分解法：把每个数分别分解质因数，再把各数中的全部公有质因数提取出来连乘，所得的积就是这几个数的最大公约数。
     * @param a
     * @param b
     * @return
     */
    public static int primeGcd(int a,int b){
//        Stack<Integer> gcdstack = new Stack();
        int result = 1;
        int maxa = Math.max(a, b);
        int minb = Math.min(a,b);
        for (int i = 2; i <= minb; i++){
            while (maxa % i == 0 && minb % i ==0){
//                gcdstack.push(i);
                result *= i;
                maxa = maxa / i;
                minb = minb / i;
            }
            while (maxa % i == 0 && minb % i !=0){
                maxa = maxa / i;
            }
            while (maxa % i != 0 && minb % i == 0){
                minb = minb / i;
            }
        }
//        int gcd = 1;
//        while (!gcdstack.empty()){
//            gcd *= gcdstack.pop();
//        }
        return result;
    }

    /**
     * 短除法：短除法求最大公约数，先用这几个数的公约数连续去除，一直除到所有的商互质为止，然后把所有的除数连乘起来，所得的积就是这几个数的最大公约数。
     * @param a
     * @param b
     * @return
     */
    public static int shortGcd(int a,int b){
        int result = 1;
        int numa = a;
        int numb = b;
        for (int i = 2; i <= numa && i <= numb; i++){
            if (numa % i == 0 && numb % i == 0){
                numa = numa / i;
                numb = numb / i;
                result *= i;
                i = 1;
            }
        }
   return result;
    }

    /**
     * 辗转相除法：辗转相除法是求两个自然数的最大公约数的一种方法，也叫欧几里德算法。
     * 计算两个非负整数p和q的最大公约数:若 q是0，则最大公约数为p。否则，将p除以 q得到余数r, p和q的最大公约数即为q和 r的最大公约数。
     * @param a 整数a
     * @param b 整数b
     * @return
     */
    public static int euclideanGcd(int a,int b){
        if (b == 0) return a;
        int r = a % b;
        return euclideanGcd(b,r);
    }

    /**
     * 更相减损法
     * 第一步：任意给定两个正整数；判断它们是否都是偶数。若是，则用2约简；若不是则执行第二步。
     * 第二步：以较大的数减较小的数，接着把所得的差与较小的数比较，并以大数减小数。继续这个操作，直到所得的减数和差相等为止。
     * 则第一步中约掉的若干个2与第二步中等数的乘积就是所求的最大公约数。
     * @param a
     * @param b
     * @return
     */
    public static int lossGcd(int a,int b){
        int maxa = Math.max(a,b );
        int minb = Math.min(a,b);
        int result = maxa - minb;
        while (result != minb){
            maxa = Math.max(result,minb);
            minb = Math.min(result,minb);
            result = maxa  - minb;
        }
        return result;
    }


}
