package Array;

public class lc1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0,right=0,maxLen=0,cost=0,length=s.length();
        while (right<length){
            cost+=Math.abs((int) (s.charAt(right))-(int)(t.charAt(right)));
            if (cost<=maxCost){
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }
            else {
                while (cost>maxCost){
                    cost-=Math.abs((int) (s.charAt(left))-(int)(t.charAt(left)));
                    left++;
                }
                right++;
            }
        }
        return maxLen;
    }
}
