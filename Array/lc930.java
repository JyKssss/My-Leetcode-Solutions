package Array;

import java.util.HashMap;

public class lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[]preSum=new int[nums.length];
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0,cnt=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            preSum[i]=sum;
        }
        map.put(0, 1);
        for (int cur : preSum) {
            cnt+=map.getOrDefault(cur-goal, 0);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        return cnt;
    }
}
