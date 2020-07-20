package DynamicProgramming;

public class lc309 {
    /**
     * 经典股票问题变形
     * dp{i,j} i表示天数 j表示股票持有
     * 本题可以用三组来代替整个dp数组降低空间复杂度
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int pre_2_sell=0,pre_1_hold=Integer.MIN_VALUE,pre_1_sell=0,cur_sell,cur_hold;
        for (int i = 0; i < prices.length; i++) {
            cur_sell=Math.max(pre_1_sell, pre_1_hold+prices[i]);
            cur_hold=Math.max(pre_1_hold, pre_2_sell-prices[i]);
            pre_2_sell=pre_1_sell;
            pre_1_hold=cur_hold;
            pre_1_sell=cur_sell;
        }
        return pre_1_sell;
    }
}
