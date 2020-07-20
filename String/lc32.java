package String;

public class lc32 {
    /**
     * 动态规划求解
     * dp[i]表示以i结尾的字符串的最长有效括号长度，如果是'('则为0
     * 是')'要判断i-1 如果是'('则dp[i]=dp[i-2]+2
     * 如果是')' 则判断 i-dp[i-1]-1是否是'('如是则dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
     * 否则为0
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int len=s.length();
        int maxLen=0;
        int[] dp=new int[len];
        for (int i = 0; i < len; i++) {
            if (i==0||s.charAt(i)=='(')dp[i]=0;
            else {
                if (s.charAt(i-1)=='(') dp[i]=i-2>=0?dp[i-2]+2:2;
                else {
                    if (i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=i-dp[i-1]-2>=0?dp[i-1]+2+dp[i-dp[i-1]-2]:dp[i-1]+2;
                    }
                    else dp[i]=0;
                }
            }
            if (dp[i]>maxLen)maxLen=dp[i];
        }
        return maxLen;
    }
}
