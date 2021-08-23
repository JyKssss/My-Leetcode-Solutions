package DynamicProgramming;

public class lc526 {
    public int countArrangement(int n) {
        int[] dp=new int[1<<n];
        dp[0]=1;
        for (int i = 1; i < 1<<n; i++) {
            int cnt=Integer.bitCount(i);
            for (int j = 1; j <= n; j++) {
                if ((j%cnt==0 || cnt%j==0) && (i&(1<<j-1))!=0){
                    dp[i]+=dp[i^(1<<j)];
                }
            }
        }
        return dp[(1<<n) -1];
    }
}
