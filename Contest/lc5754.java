package Contest;

public class lc5754 {
    public int countGoodSubstrings(String s) {
        if (s.length()<3){
            return 0;
        }
        int[] charCount=new int[26];
        int i=2,end=s.length(),count=0;
        charCount[s.charAt(0)-'a']++;
        charCount[s.charAt(1)-'a']++;
        while (i<end){
            charCount[s.charAt(i)-'a']++;
            if (verify(charCount)){
                count++;
            }
            charCount[s.charAt(i-2)-'a']--;
            i++;
        }
        return count;
    }

    private boolean verify(int[] count){
        for (int i : count) {
            if (i>1){
                return false;
            }
        }
        return true;
    }
}
