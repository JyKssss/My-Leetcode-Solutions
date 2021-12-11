package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class lc1647 {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'] += 1;
        }
        Arrays.sort(cnt);
        HashSet<Integer> cntSet = new HashSet<>();
        int deletionCnt = 0;
        for (int c : cnt) {
            if (c != 0) {
                while (cntSet.contains(c) && c != 0) {
                    c -= 1;
                    deletionCnt += 1;
                }
                if (c != 0) {
                    cntSet.add(c);
                }
            }
        }
        return deletionCnt;
    }
}
