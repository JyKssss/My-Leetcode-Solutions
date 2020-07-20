package String;

public class lc76 {
    /**
     * 同样使用滑动窗口大法
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length()<t.length())return new String();
        String res=new String();
        int[]need=new int['z'-'A'+1],window=new int['z'-'A'+1];
        int totalChar=0,target=0,left=0,right=0,minLen=Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            if (need[t.charAt(i)-'A']==0)target++;
            need[t.charAt(i)-'A']++;
        }

        while (right<s.length()){
            char r=s.charAt(right);
            right++;
            if (need[r-'A']>0){
                window[r-'A']++;
                if (window[r-'A']==need[r-'A']){
                    totalChar++;
                }
            }

            while (totalChar==target){
                if (right-left+1<minLen){
                    minLen=right-left+1;
                    res=s.substring(left, right);
                }
                char l=s.charAt(left);
                left++;
                if (need[l-'A']>0){
                    window[l-'A']--;
                    if (window[l-'A']<need[l-'A'])totalChar--;
                }
            }
        }
        return res;
    }
}
