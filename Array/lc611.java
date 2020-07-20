package Array;

import java.util.Arrays;

public class lc611 {
    public int triangleNumber(int[] nums) {
        int count=0;
        if (nums.length<=2)return 0;
        int p,q,r,l1,l2,l3;
        Arrays.sort(nums);
        for ( p = 0; p <nums.length-2 ; p++) {
            l1=nums[p];
            q=p+1;
            r=q+1;
            for ( q=p+1 ; q <nums.length-1 ; q++) {
                if (r==nums.length-1)count+=(r-q);
                if (r==q && r<nums.length-1)r++;
                else {
                    while (l1+nums[q]>nums[r]){
                        r++;
                        if (r==nums.length)break;
                    }
                    count+=r-q-1;
                    if (r-q-1>0)r--;


                }
            }
        }
        return count;
    }
}
