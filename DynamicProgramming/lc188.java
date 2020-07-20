package DynamicProgramming;

public class lc188 {
    /**
     * dp{i,j,k}
     * i表示日期
     * j表示最多允许购买次数
     * k表示是否持有
     * 同时要优化空间复杂度
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][k+1][2];
        for (int i = 0; i <=k ; i++) {
            dp[0][i][0]=0;
            dp[0][i][1]=Integer.MIN_VALUE;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j <=k ; j++) {
                if (j==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=Integer.MIN_VALUE;
                }
                else {
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
                }
            }
        }
        return dp[prices.length][k][0];
    }

    /**
     * 优化时间复杂度
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit2(int k, int[] prices) {
        if (k>prices.length/2){
            int p_hold,p_sell,c_hold,c_sell;
            p_hold=Integer.MIN_VALUE;
            p_sell=0;
            for (int i = 0; i < prices.length; i++) {
                c_hold= Math.max(p_hold, p_sell-prices[i]);
                c_sell=Math.max(p_sell, p_hold+prices[i]);
                p_hold=c_hold;
                p_sell=c_sell;
            }
            return p_sell;
        }
        int[] pre_hold=new int[k+1];
        int[] pre_sell=new int[k+1];
        int[] cur_hold=new int[k+1];
        int[] cur_sell=new int[k+1];
        //初始化
        for (int i = 0; i <=k; i++) {
            pre_hold[i]=Integer.MIN_VALUE;
            pre_sell[i]=0;
        }
        for (int i = 1; i <=prices.length ; i++) {
            for (int j = 0; j <=k ; j++) {
                if (j==0){
                    cur_hold[j]=Integer.MIN_VALUE;
                    cur_sell[j]=0;
                }
                else {
                    cur_hold[j]=Math.max(pre_hold[j],pre_sell[j-1]-prices[i-1]);
                    cur_sell[j]= Math.max(pre_sell[j],pre_hold[j]+prices[i-1]);
                }

            }
            pre_hold=cur_hold;
            pre_sell=cur_sell;
        }
        return cur_sell[k];
    }
}
