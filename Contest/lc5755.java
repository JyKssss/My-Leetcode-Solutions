package Contest;

import java.util.Arrays;

public class lc5755 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0,len=nums.length;
        for (int i = 0; i < len/2; i++) {
            max=Math.max(max, nums[i]+nums[len-1-i]);
        }
        return max;
    }
}
