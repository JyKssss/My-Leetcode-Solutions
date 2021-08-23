package DynamicProgramming;

public class lc552 {
    /**
     * dp[i][j][k] i表示天数 j表示缺勤天数(<2 days) k表示连续迟到天数(<3 days)
     * 迟到和缺勤不同时出现
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        int[][][] dp=new int[n][2][3];
        final int MOD=1000000007;
        dp[0][0][0]=1;
        dp[0][1][0]=1;
        dp[0][0][1]=1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j==0){
                        if (k==0){
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][0]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][1]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][2]%MOD)%MOD;
                        }
                        else {
                            dp[i][j][k]=(dp[i-1][j][k-1])%MOD;
                        }
                    }
                    else {
                        if (k==0){
//                            dp[i][j][k]=(dp[i-1][j][0]%MOD+dp[i-1][j][1]%MOD+dp[i-1][j][2]%MOD+dp[i-1][j-1][0]%MOD+dp[i-1][j-1][1]%MOD+dp[i-1][j-1][2]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][0]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][1]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j][2]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j-1][0]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j-1][1]%MOD)%MOD;
                            dp[i][j][k]=(dp[i][j][k]+dp[i-1][j-1][2]%MOD)%MOD;
                        }
                        else {
                            dp[i][j][k]=(dp[i-1][j][k-1])%MOD;
                        }
                    }
                }
            }
        }
        int sum=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum+=dp[n-1][i][j]%MOD;
                sum=sum%MOD;
            }
        }
        return sum;
    }
}
