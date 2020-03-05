package algs4;

import java.util.Arrays;

/**
 * 矩阵库
 */
public class MatrixOps {
    /**
     * 向量相乘
     * @param x
     * @param y
     * @return
     */
    private static double dot(double[] x ,double[] y){
        int length = x.length;
        double result = 0;
        for (int i = 0; i < length; i++){
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * 矩阵和矩阵相乘
     * @param a
     * @param b
     * @return
     */
    private static double[][] mult(double[][] a,double[][] b){
        int arows = a.length;
        int acols = a[0].length;
        int bcols = b[0].length;
        double[][] result = new double[arows][bcols];
        for (int i = 0; i < arows; i++){

            for (int j = 0; j < bcols; j++){
                int res = 0;
                for (int z = 0 ; z < acols; z++){
                    res += a[i][z] * b[z][j];
                }
                result[i][j] = res;
            }
        }

        return result;
    }

    /**
     * 矩阵转置
     * @param a
     * @return
     */
    private static double[][] transpose(double[][] a){
        double[][] result = new double[a[0].length][a.length];
        for (int i =0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    /**
     * 矩阵和向量之积
     * @param a
     * @param x
     * @return
     */
    private static double[] mult(double[][] a,double[] x){
        double[] result = new double[a.length];
        for (int i =0 ; i < a.length; i++){
            int res = 0;
            for (int j = 0; j < a[0].length; j++){
                res += a[i][j]* x[j];
            }
            result[i] = res;
        }
        return result;
    }

    /**
     * 向量和矩阵之积
     * @param x
     * @param a
     * @return
     */
    private static double[]mult(double[] x, double[][] a){
        double[] result = new double[a[0].length];
        for (int i = 0;i < a[0].length;i++){
            for (int j = 0; j < x.length; j++){
                result[i] += x[j] * a[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        double[]  x = {1,2,3};
        double[] y = {4,5,6};
        double[][] a = {{1,2},{3,4},{5,6}};
        double[][] b = {{3,4,5},{6,7,8}};
        double result = dot(x,y);
        System.out.println(result);
        double[][] result1 = mult(a,b);
        for (int i =0; i < a.length;i++){
            System.out.println(Arrays.toString(result1[i]));
        }
        System.out.println("---------------------");

        double[][] result2 = transpose(a);
        for (int j = 0; j < result2.length; j++){
            System.out.println(Arrays.toString(result2[j]));
        }

        System.out.println("---------------------");

        double[] result3 = mult(b,x);

        System.out.println(Arrays.toString(result3));


        System.out.println("---------------------");

        double[] result4 = mult(x,a);
        System.out.println(Arrays.toString(result4));

    }
}
