package DynamicProgramming;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i][j]表示用前i个硬币 所能构成j金额的最少次数
        int[][] dpTable=new int[coins.length+1][amount+1];
        for (int i = 1; i <= amount; i++) {
            dpTable[0][i]=-1;
        }
        for (int i = 1; i <=coins.length ; i++) {
            for (int j = 1; j <=amount ; j++) {
                int coin=coins[i-1];
                if (j-coin>=0){
                    int a=dpTable[i][j-coin],b=dpTable[i-1][j];
                    if (a>=0&&b>=0){
                        dpTable[i][j]=Math.min(a+1, b);
                    }
                    else if (a>=0){
                        dpTable[i][j]=a+1;
                    }
                    else if (b>=0){
                        dpTable[i][j]=b;
                    }
                    else {
                        dpTable[i][j]=-1;
                    }
                }
                else {
                    dpTable[i][j]=dpTable[i-1][j];
                }
            }
        }
        return dpTable[coins.length][amount];
    }
}
