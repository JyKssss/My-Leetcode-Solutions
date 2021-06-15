package DynamicProgramming;

public class lc879 {
    /**
     * 动态规划 dp[i][j][k] 表示前i件工作在使用j个员工的情况下 profit>=k的组合数
     * dp[i][j][k]=dp[i-1][j][k]/ dp[i-1][j][k]+dp[i-1][j-group[i][max(0,k-profit[i])]
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int workNum=profit.length, mod= (int) (Math.pow(10, 9)+7);
        int[][][] dp=new int[workNum+1][n+1][minProfit+1];
        for (int i = 0; i < n+1; i++) {
            dp[0][i][0]=1;
        }
        for (int i = 1; i <=workNum ; i++) {
            int curProfit=profit[i-1],curWorker= group[i-1];
            for (int j = 0; j <=n ; j++) {
                for (int k = 0; k <=minProfit ; k++) {
                    dp[i][j][k]=dp[i-1][j][k];
                    if (curWorker<=j){
                        dp[i][j][k]+=dp[i-1][j-curWorker][Math.max(0, k-curProfit)];
                        dp[i][j][k]=dp[i][j][k]%mod;
                    }
                }
            }
        }
        return dp[workNum][n][minProfit];
    }
}
