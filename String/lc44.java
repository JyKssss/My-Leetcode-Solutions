package String;

public class lc44 {
    /**
     * 状态转移方程 三种情况 小写字母 ？ *
     * dp{i,j}表示字符串s的前i字符与模式p的前j个是否匹配
     * 三种转移
     * 小写字母：
     * ？ ：
     * * ：
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //初始化
        dp[0][0]=true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0]=false;
        }
        for (int i = 1; i <= p.length() ; i++) {
            dp[0][i]=dp[0][i-1]&&(p.charAt(i-1)=='*');
        }

        //dp
        for (int i = 1; i <= s.length() ; i++) {
            char cur=s.charAt(i-1);
            for (int j = 1; j <= p.length() ; j++) {
                char curp=p.charAt(j-1);
                if (curp>='a'&&curp<='z'){
                    dp[i][j]=dp[i-1][j-1]&&(curp==cur);
                }
                else if (curp=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
