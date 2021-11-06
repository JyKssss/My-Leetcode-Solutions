package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int [] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer>indexMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] - difference;
            if (indexMap.containsKey(target)){
                dp[i] += dp[indexMap.get(target)];
                max = Math.max(max, dp[i]);
            }
            indexMap.put(arr[i], i);
        }
        return max;
    }
}
