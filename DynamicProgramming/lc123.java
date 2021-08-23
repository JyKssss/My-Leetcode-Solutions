package DynamicProgramming;

public class lc123 {

    public int maxProfit(int[] prices) {
        /*
        dp[i][j][k] i：日期  j: 是否持有股票 0:1  k：交易的次数 0 1 2
         */
        int[][][]dp=new int[prices.length][2][3];
        int price;
        //初始状态
        dp[0][0][0]=0;
        dp[0][1][0]=-prices[0];
        dp[0][0][1]=Integer.MIN_VALUE/2;
        dp[0][0][2]=Integer.MIN_VALUE/2;
        dp[0][1][1]=Integer.MIN_VALUE/2;
        dp[0][1][2]=Integer.MIN_VALUE/2;

        for (int i = 1; i < prices.length ; i++) {
            price=prices[i];
            dp[i][0][0]=dp[i-1][0][0];
            dp[i][1][0]=Math.max(dp[i-1][1][0], dp[i-1][0][0]-price);
            dp[i][0][1]=Math.max(dp[i-1][0][1], dp[i-1][1][0]+price);
            dp[i][0][2]=Math.max(dp[i-1][0][2], dp[i-1][1][1]+price);
            dp[i][1][1]=Math.max(dp[i-1][1][1], dp[i-1][0][1]-price);
            dp[i][1][2]=Integer.MIN_VALUE/2;
        }
        return Math.max(Math.max(dp[prices.length-1][0][2],dp[prices.length-1][0][1]),0);
    }
}
