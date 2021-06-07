package DynamicProgramming;

public class lc474 {
    public int findMaxForm(String[] strs, int m, int n) { // m:0  n:1
        int len=strs.length,zeros,ones;
        int[][][] dp=new int[len+1][m+1][n+1];
        for (int i = 1; i <= strs.length; i++) {
            zeros=computeZeros(strs[i-1]);
            ones=strs[i-1].length()-zeros;
            for (int j = 0; j <=m ; j++) {
                for (int k = 0; k <=n ; k++) {
                    if (j-zeros>=0 && k-ones>=0){
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-zeros][k-ones]+1);
                    }
                    else {
                        dp[i][j][k]=dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int computeZeros(String str){
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)-'0'==0){
                count++;
            }
        }
        return count;
    }
}
