package String;

public class lc516 {
    /**
     * 状态转移方程：
     * d[i][j]= d[i+1][j-1]+2（边缘相等） / max(d[i][j-1],d[i+1][j]) （边缘不等）
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int [][] dp=new int[s.length()][s.length()];
        char[] chars=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=1;
        }
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
            }
            else dp[i][i+1]=1;
        }
        for (int len = 3; len <=s.length() ; len++) {
            for (int i = 0; i < s.length(); i++) {
                int start=i,end=i+len-1;
                if (end>s.length()-1)break;
                if (chars[start]==chars[end]){
                    dp[start][end]=dp[start+1][end-1]+2;
                }
                else dp[start][end]=Math.max(dp[start+1][end],dp[start][end-1]);
            }
        }
        return dp[0][s.length()-1];
    }
}
