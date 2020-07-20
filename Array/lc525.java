package Array;

import java.util.HashMap;

public class lc525 {
    public int findMaxLength(int[] nums) {
        int sum=0,maxLen=0;
        HashMap<Integer,Integer>preSumMap=new HashMap<>();
        preSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]==0?-1:1;
            if (!preSumMap.containsKey(sum))preSumMap.put(sum, i);
            else {
                int index=preSumMap.get(sum);
                maxLen=Math.max(maxLen, i-index);
            }
        }
        return maxLen;
    }
}
