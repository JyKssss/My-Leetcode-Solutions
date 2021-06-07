package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class lc523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] preSum= new int[nums.length+1];
        int remain;
        HashMap<Integer,Integer>remainMap=new HashMap<>();
        remainMap.put(0, 0);
        for (int i = 1; i <= nums.length ; i++) {
            preSum[i]=preSum[i-1]+nums[i];
            remain=preSum[i]%k;
            if (remainMap.containsKey(remain)){
                if (i-remainMap.get(remain)>1){
                    return true;
                }
            }
            else {
                remainMap.put(remain, i);
            }
        }
        return false;
    }
}
