package DynamicProgramming;

import java.util.Arrays;

public class lc1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum= Arrays.stream(stones).sum(),weight,max=0;
        boolean dp[][]=new boolean[stones.length+1][sum+1];
        for (int i = 0; i <=stones.length ; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i <=stones.length ; i++) {
            weight=stones[i-1];
            for (int j = 0; j <=sum ; j++) {
                if (j<weight){
                    dp[i][j]=dp[i-1][j];
                }
                else if (dp[i-1][j-weight] || dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }

        for (int i = sum/2; i >=0 ; i--) {
            if (dp[stones.length][i]){
                max=i;
                break;
            }
        }
        return sum-2*max;
    }

    public static void main(String[] args) {
        lc1049 obj=new lc1049();
        int[] stones=new int[]{1,2};
        System.out.println(obj.lastStoneWeightII(stones));
    }
}
