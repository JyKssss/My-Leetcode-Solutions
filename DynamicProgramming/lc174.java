package DynamicProgramming;

import java.util.Arrays;

public class lc174 {
    //dp{i,j}表示该位置上到终点所需的最小值
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int n=dungeon.length,m=dungeon[0].length;
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[n-1][m]=dp[n][m-1]=1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                int min=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(min-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
