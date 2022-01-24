package DynamicProgramming;

public class lc122 {
    public int maxProfit(int[] prices) {
        // 0 for not holding 1 for holding
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price);
        }

        return dp[prices.length - 1][0];
    }
}
