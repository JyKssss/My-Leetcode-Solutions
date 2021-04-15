package Search;

import java.util.HashMap;

public class lc87 {
    HashMap<String,Boolean>memoMap;
    public boolean isScramble(String s1, String s2) {
        this.memoMap=new HashMap<>();
        return isScrambleHelper(s1, s2);
    }

    private boolean isScrambleHelper(String s1, String s2) {
        String key=s1+"_"+s2;
        if (memoMap.containsKey(key)){
            return memoMap.get(key);
        }
        if (s1.equals(s2)){
            memoMap.put(key, true);

            return true;
        }
        int[] charsCnt=new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charsCnt[s1.charAt(i)-'a']++;
            charsCnt[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < charsCnt.length; i++) {
            if (charsCnt[i]!=0){
                memoMap.put(key, false);
                return false;
            }
        }

        for (int i = 0; i < s1.length()-1; i++) {
            if (isScrambleHelper(s1.substring(0, i+1), s2.substring(0, i+1)) &&
                    isScrambleHelper(s1.substring(i+1),s2.substring(i+1))){
                memoMap.put(key, true);
                return true;
            }
            if (isScrambleHelper(s1.substring(0, i+1), s2.substring(s1.length()-i-1)) &&
                    isScrambleHelper(s1.substring(i+1),s2.substring(0, s2.length()-i-1))){
                memoMap.put(key, true);
                return true;
            }
        }
        memoMap.put(key, false);
        return false;
    }
}
