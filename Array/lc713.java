package Array;

public class lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int p2=0,multi=nums[0],total=0;
        if (nums.length==1)return nums[0]<k?1:0;
        if (k<=1)return 0;
        for (int p1 = 0; p1 < nums.length; p1++) {
            if (p1>0)multi/=nums[p1-1];
            while (multi<k&&p2<nums.length-1){
                p2++;
                multi*=nums[p2];
            }
            if (multi<k)total+=p2-p1+1;
            else total+=p2-p1;
        }
        return total;
    }
}
