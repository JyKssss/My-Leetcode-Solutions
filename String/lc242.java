package String;

public class lc242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;
        int[]need=new int[26], window=new int[26];
        int target=0,totalChar=0;
        for (int i = 0; i < s.length(); i++) {
            if (need[s.charAt(i)-'a']==0)target++;
            need[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (need[t.charAt(i)-'a']>0){
                window[t.charAt(i)-'a']++;
                if (window[t.charAt(i)-'a']==need[t.charAt(i)-'a'])totalChar++;
            }
            else return false;
        }
        return target==totalChar;
    }
}
