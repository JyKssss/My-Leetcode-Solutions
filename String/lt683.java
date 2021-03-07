package String;

import java.util.HashSet;
import java.util.Set;

public class lt683 {
    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        s=s.toLowerCase();
        Set<String>dictLower=new HashSet<>();
        for (String str: dict){
            dictLower.add(str.toLowerCase());
        }
        int[][] dp=new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                if (dictLower.contains(s.substring(i, j+1))){
                    dp[i][j]=1;
                }
            }
        }
        //为何不倒序搜索 会产生重复计算
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j <s.length() ; j++) {
                for (int k = i; k <j ; k++) {
                    dp[i][j]+=dp[i][k]*dp[k+1][j];
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
