package Array;

import java.util.Arrays;

public class lc16 {
    public int threeSumClosest(int[] nums, int target) {
        int closestNum=nums[0]+nums[1]+nums[2];
        int minus =Math.abs(nums[0]+nums[1]+nums[2]-target);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            int result;
            while(j<k){
                result =nums[i]+nums[j]+nums[k];
                if(Math.abs(result-target)<minus){
                    closestNum=result;
                }
                minus = minus>Math.abs(result-target)?Math.abs(result-target):minus;

                if(result-target==0){
                    return result;
                }
                else if(result>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return closestNum;

    }
}
