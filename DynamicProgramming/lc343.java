package DynamicProgramming;

public class lc343 {
    public int integerBreak(int n) {
        if (n==1||n==0)return 0;
        int[] dp=new int[n+1];
        for (int i = 2; i <=n ; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                max=Math.max(Math.max(j*(i-j), j*dp[i-j]),max);
            }
        }
        return dp[n];
    }
}
