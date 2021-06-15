package DynamicProgramming;

import java.util.Arrays;

public class lc1449 {
    public String largestNumber(int[] cost, int target) {
        int len=cost.length;
        String[] dp=new String[target+1];
        Arrays.fill(dp, "*");
        dp[0]="";
        for (int i = 1; i <=len ; i++) {
            int curCost=cost[i-1];
            for (int j = 1; j <=target ; j++) {
                if (j-curCost>=0 && !dp[j-curCost].equals("*")){
                    dp[j]=compareStrBuffer(dp[j],i+dp[j-curCost]);
                }
            }
        }
        return dp[target].equals("*")?"0":dp[target];
    }

    private String compareStrBuffer(String s1, String s2){
        if (s1.length()>s2.length()){
            return s1;
        }
        else if (s2.length()>s1.length()){
            return s2;
        }
        return s1.compareTo(s2)>0?s1:s2;
    }
}
