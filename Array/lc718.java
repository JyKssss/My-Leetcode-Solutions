package Array;

public class lc718 {
    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length][B.length];
        int maxLen=0;
        for (int i = 0; i < A.length; i++) {
            dp[i][0]=A[i]==B[0]?1:0;
            maxLen=Math.max(maxLen, dp[i][0]);
        }
        for (int i = 0; i < B.length; i++) {
            dp[0][i]=A[0]==B[i]?1:0;
            maxLen=Math.max(maxLen, dp[0][i]);
        }
        for (int i = 1; i <A.length ; i++) {
            for (int j = 1; j <B.length ; j++) {
                if (A[i]==B[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxLen=Math.max(maxLen, dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return maxLen;
    }
}
