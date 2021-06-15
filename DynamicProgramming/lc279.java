package DynamicProgramming;

public class lc279 {
    public int numSquares(int n) {
        int squareNum= (int) Math.sqrt(n);
        int[][] dp=new int[squareNum+1][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[1][i]=i;
        }

        for (int i = 2; i <=squareNum ; i++) {
            int m=i*i;
            for (int j = 0; j <=n ; j++) {
                int index=1;
                dp[i][j]=dp[i-1][j];
                while (j-index*m>=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-index*m]+index);
                    index++;
                }
            }
        }
        return dp[squareNum][n];
    }

    public int numSquares2(int n) {
        int squareNum= (int) Math.sqrt(n);
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i = 1; i <=n ; i++) {
            dp[i]=i;
            for (int j = 1; j <=squareNum ; j++) {
                if (i-j*j>=0){
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                }
                else break;
            }
        }
        return dp[n];
    }
}
