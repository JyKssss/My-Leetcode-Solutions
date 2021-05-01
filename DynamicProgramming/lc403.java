package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc403 {
    /*
    HashSet来记录每个Stone
     */
    public boolean canCross(int[] stones) {
        List<HashSet<Integer>>dp=new ArrayList<>();
        dp.add(new HashSet<>());
        dp.get(0).add(0);
        for (int i = 1; i <stones.length ; i++) {
            dp.add(new HashSet<>());
            int cur=stones[i],prev;
            HashSet<Integer>prevSet;
            for (int j = i-1; j >=0 ; j--) {
                prev=stones[j];
                prevSet=dp.get(j);
                if (prevSet.contains(cur-prev)|| prevSet.contains(cur-prev+1)|| prevSet.contains(cur-prev-1)){
                    dp.get(i).add(cur-prev);
                }
            }
        }
        return dp.get(stones.length-1).size()>0;
    }

    /*
    效率更高的dp
    dp[i][k]表示第i块石头能不能通过k跳到达
     */
    public boolean canCross2(int[] stones) {
        int len= stones.length;
        boolean[][] dp=new boolean[len][len];
        dp[0][0]=true;
        for (int i = 1; i <len ; i++) {
            int cur=stones[i],prev;
            for (int j = i-1; j >=0 ; j--) {
                prev=stones[j];
                int k=cur-prev;
                if (k>j+1){
                    continue;
                }
                if ((k-1>=0 && dp[j][k-1])||dp[j][k]||dp[j][k+1]){
                    dp[i][k]=true;
                }

                if (i==len-1&&dp[i][k]){
                    return true;
                }
            }
        }
        return false;
    }
}
