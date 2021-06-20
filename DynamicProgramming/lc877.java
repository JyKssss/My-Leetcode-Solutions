package DynamicProgramming;

import java.util.List;

public class lc877 {
    /**
     * dp[i][j]表示在i到j之间的堆当中 选择方的最大差值
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int[][] dp=new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i]=piles[i];
        }
        for (int len = 2; len <= piles.length ; len++) {
            for (int start = 0; start <= piles.length-len ; start++) {
                dp[start][start+len-1]=Math.max(piles[start]-dp[start+1][start+len-1],piles[start+len-1]-dp[start][start+len-2] );
            }
        }
        return dp[0][piles.length-1]>0;
    }
}
