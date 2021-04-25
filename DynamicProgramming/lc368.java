package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp=new int[nums.length];
        int maxIndex=0,max=0;
        dp[0]=1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int cur=nums[i];
            for (int j = i; j >=0 ; j--) {
                if (cur%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if (dp[i]>max){
                        max=dp[i];
                        maxIndex=i;
                    }
                }
            }
        }

        List<Integer>res=new ArrayList<>();
        res.add(nums[maxIndex]);
        for (int i = maxIndex-1; i >=0 ; i--) {
            if (nums[maxIndex]%nums[i]==0 && dp[i]==max-1){
                maxIndex=i;
                max=dp[i];
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc368 obj=new lc368();
        int[] nums=new int[]{2,3,8,9,27};
        System.out.println(obj.largestDivisibleSubset(nums));
    }
}
