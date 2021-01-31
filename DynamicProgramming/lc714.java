package DynamicProgramming;

public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length<2)return 0;
        int[] holdStock=new int[prices.length];
        int[] soldStock=new int[prices.length];
        holdStock[0]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            holdStock[i]=Math.max(holdStock[i-1],soldStock[i-1]-prices[i] );
            soldStock[i]=Math.max(soldStock[i-1],holdStock[i-1]+prices[i]-fee );
        }
        return soldStock[prices.length-1];
    }
}
