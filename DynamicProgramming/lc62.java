package DynamicProgramming;

import java.math.BigInteger;
import java.sql.SQLOutput;


public class lc62 {
    /**
     * 组合数解法
     */
    public static int uniquePaths(int m, int n) {
        BigInteger sum=new BigInteger(String.valueOf(m+n-2));
        BigInteger a=new BigInteger(String.valueOf(m-1));
        BigInteger b=new BigInteger(String.valueOf(n-1));
        BigInteger res=factorial(sum).divide(factorial(a).multiply(factorial(b)));
        return res.intValue();
    }
    public static BigInteger factorial(BigInteger k){
        if (k.equals(1)||k.equals(0))return new BigInteger("1");
        BigInteger res =new BigInteger("1");
        for (int i = 1; i <= k.intValue(); i++) {
            res=res.multiply(new BigInteger(String.valueOf(i)));
        }
        return res;
    }

    /**
     * DP f(n,m)=f(n-1,m)+f(n,m-1)
     *
     */

    public static int uniquePaths2(int m, int n) {
        int[][] res=new int[m][n];
        for (int i = 0; i <m ; i++) {
            res[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                res[i][j]=res[i][j-1]+res[i-1][j];
            }
        }
        return res[m-1][n-1];
    }
    public static void main(String[] args) {
//        System.out.println(factorial(18)/(factorial(9)*factorial(9)));
//        System.out.println(uniquePaths(23, 12));
        System.out.println(uniquePaths2(10, 10));
    }

}
