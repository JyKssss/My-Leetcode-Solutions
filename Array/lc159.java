package Array;

import java.util.HashMap;
import java.util.Map;

public class lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            map.putIfAbsent(cur, 0);
            map.put(cur, map.get(cur) +1);
            while (map.size() > 2) {
                char lCur = s.charAt(left);
                map.put(lCur, map.get(lCur) - 1);
                if (map.get(lCur) == 0) {
                    map.remove(lCur);
                }
                left += 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right += 1;
        }
        return maxLen;
    }
}
