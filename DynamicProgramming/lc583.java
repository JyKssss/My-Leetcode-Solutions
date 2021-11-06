package DynamicProgramming;

import java.util.TreeMap;

public class lc583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int max = 0;
        TreeMap<Integer, Integer>map =new TreeMap<>();
        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return word1.length() + word2.length() - 2 * max;
    }
}
