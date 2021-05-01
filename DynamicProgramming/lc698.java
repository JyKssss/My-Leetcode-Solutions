package DynamicProgramming;

import java.util.Arrays;

public class lc698 {
    /**
     * dfs搜索解法
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum= Arrays.stream(nums).sum(),target=sum/k,index= nums.length-1;
        if (sum%k!=0){
            return false;
        }
        Arrays.sort(nums);
        if (nums[index]>target){
            return false;
        }
        return dfs(nums, new int[k], target, index);
    }

    private boolean dfs(int[] nums, int[] group, int target, int index){
        if (index<0){
            return true;
        }
        int cur=nums[index];
        for (int i = 0; i < group.length; i++) {
            if (group[i]+cur<=target){
                group[i]+=cur;
                if (dfs(nums, group, target, index-1)){
                    return true;
                }
                group[i]-=cur;
            }
            if (group[i]==0){
                break;
            }
        }
        return false;
    }


}
