package Array;

public class lc209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null||nums.length==0)return 0;
        if (nums.length==1)return nums[0]>s?1:0;
        int sum=0,minLen=Integer.MAX_VALUE,len,p1,p2=0;
        for ( p1 = 0; p1 <nums.length ; p1++) {
            if (p1==0)sum+=nums[0];
            else sum-=nums[p1-1];
            while (sum<s){
                if (p2<nums.length-1){
                    p2++;
                    sum+=nums[p2];
                }
                else return minLen==Integer.MAX_VALUE?0:minLen;
            }
            while (sum>s){
                if (sum-nums[p2]>=s)p2--;
                else break;
            }
            minLen=Math.min(minLen, p2-p1+1);
        }
        return minLen;
    }
}
