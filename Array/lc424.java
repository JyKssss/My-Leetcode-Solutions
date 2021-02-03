package Array;

public class lc424 {
    /**
     * O(26n)算法
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        for (int i = 0; i < 26; i++) {
            char c= (char) ('A'+i);
            int p=0,q=0,count=0,maxCharLen=0;
            while (q<s.length()){
                if (s.charAt(q)==c){
                    q++;
                }
                else if (s.charAt(q)!=c && count<k){
                    q++;
                    count++;
                }
                else {
                    while (count>=k){
                        if (p<q && s.charAt(p)==c){
                            p++;
                        }
                        else if (p<q && s.charAt(p)!=c){
                            p++;
                            count--;
                        }
                        else {
                            p++;
                            q++;
                            break;
                        }
                    }
                }
                maxCharLen=Math.max(maxCharLen, q-p);
            }
            maxLen=Math.max(maxLen, maxCharLen);
        }
        return maxLen;
    }

    /**
     * 官方题解的O(n)
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement2(String s, int k) {
        int[] charCount=new int[26];
        int left=0,right=0,maxSame=0,length=s.length();
        while (right<length){
            charCount[s.charAt(right)-'A']++;
            maxSame=Math.max(maxSame, charCount[s.charAt(right)-'A']);
            if (right-left+1-maxSame>k){
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }


    public static void main(String[] args) {
        lc424 obj=new lc424();
        String s="AACC";
        int k=0;
        System.out.println(obj.characterReplacement(s, k));
    }
}
