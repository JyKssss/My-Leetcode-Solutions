package String;

public class lc567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length())return false;
        int[] need=new int[26],window=new int[26];
        int left=0,right=0,target=0,totalChar=0;
        for (int i = 0; i < s1.length(); i++) {
            if (need[s1.charAt(i)-'a']==0)target++;
            need[s1.charAt(i)-'a']++;
        }

        while (right<s2.length()){
            char r=s2.charAt(right);
            right++;
            if (need[r-'a']>0){
                window[r-'a']++;
                if (window[r-'a']==need[r-'a'])totalChar++;
            }

            while (right-left>=s1.length()){
                if (target==totalChar)return true;
                char l=s2.charAt(left);
                left++;
                if (need[l-'a']>0){
                    if (need[l-'a']==window[l-'a']){
                        totalChar--;
                    }
                    window[l-'a']--;
                }
            }
        }
        return false;
    }
}
