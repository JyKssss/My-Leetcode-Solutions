package DynamicProgramming;

public class lc518 {
    public int change(int amount, int[] coins) {
        //dp[i][j] i表示前i个硬币  j表示金额
        //base case dp[0][j]=0  dp[i][0]=1 状态压缩
        //状态转移： dp[j]=dp[j]+dp[j-coins[i]](if j-coins[i]>=0)
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount ; j++) {
                int coin=coins[i-1];
                if (j-coin>=0){
                    dp[j]=dp[j]+dp[j-coin];
                }

            }
        }
        return dp[amount];
    }
}
