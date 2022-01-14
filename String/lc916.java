package String;

import java.util.ArrayList;
import java.util.List;

public class lc916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] charMap = new int[26];
        for (String b : B) {
            int[] bMap = new int[26];
            for (int i = 0; i < b.length(); i++) {
                bMap[b.charAt(i) - 'a'] += 1;
            }
            for (int i = 0; i < bMap.length; i++) {
                charMap[i] = Math.max(charMap[i], bMap[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String a : A) {
            int[] aMap = new int[26];
            for (int i = 0; i < a.length(); i++) {
                aMap[a.charAt(i) - 'a'] += 1;
            }
            boolean isSubset = true;
            for (int i = 0; i < aMap.length; i++) {
                if (aMap[i] > charMap[i]) {
                    isSubset = false;
                }
            }
            if (isSubset) {
                result.add(a);
            }
        }
        return result;
    }
}
