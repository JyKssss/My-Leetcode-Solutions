package String;

public class lc395 {
    public int longestSubstring(String s, int k) {
        if (s.length()<k){
            return 0;
        }
        char[] chars=s.toCharArray();
        int[] charCnt=new int[26];
        for(char c:chars){
            charCnt[c-'a']++;
        }
        int l=0,res=0;
        for (int r = 0; r <chars.length; r++) {
            if (charCnt[chars[r]-'a']<k){
                res=Math.max(res, longestSubstring(s.substring(l, r), k));
                l=r+1;
            }
        }
        return l==0?s.length():Math.max(res, longestSubstring(s.substring(l, s.length()), k));
    }
}
