package Search;

import java.util.HashMap;

public class lc377 {
    int cnt;
    HashMap<Integer,Integer>memo;
    public int combinationSum4(int[] nums, int target) {
//        this.cnt=0;
//        this.memo=new HashMap<>();
//        memo.put(0, 1);
//        dfs( target, 0, nums);
//        return dfsMemo(target, nums);
            return dpSolu(target, nums);
    }


    /**
     * 朴素的DFS遍历
     * @param target
     * @param sum
     * @param nums
     */
    private void dfs(int target,int sum, int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            if (sum+nums[i]<target){
                dfs( target, sum+nums[i],nums);
            }
            else if (sum+nums[i]==target){
                cnt++;
            }

        }
    }

    /**
     * 记忆化递归
     * @param target
     * @param nums
     * @return
     */
    private int dfsMemo(int target,int[] nums){
        if (memo.containsKey(target)){
            return memo.get(target);
        }
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=target){
                cnt+=dfsMemo(target-nums[i],nums);
            }
        }
        memo.put(target, cnt);
        return cnt;
    }

    /**
     * 动态规划解法
     * @param target
     * @param nums
     * @return
     */
    private int dpSolu(int target, int[] nums){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i-num>=0){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }

}
