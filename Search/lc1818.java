package Search;

import java.util.Arrays;

public class lc1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] tmp=nums1.clone();
        int maxGain=0,n2,n1,diff,MOD=1000000007,sum=0;
        Arrays.sort(tmp);
        for (int i = 0; i < nums2.length; i++) {
            n1=nums1[i];
            n2=nums2[i];
            diff=Math.abs(n1-n2);
            sum+=diff;
            sum%=MOD;
            maxGain=Math.max(maxGain, Math.abs(diff-binarySearch(tmp, n2)));
        }
        sum=(sum-maxGain+MOD)%MOD;

        return sum;
    }

    private int binarySearch(int[] nums, int n){
        int start=0,end=nums.length-1,mid=0,diff;
        while (start<end){

            mid=start+(end-start+1)/2;
            if (nums[mid]>n){
                end=mid-1;
            }
            else if (nums[mid]<=n){
                start=mid;
            }
        }
        diff=n-nums[mid];
        if (diff>0 && mid< nums.length-1){
            return Math.min(diff, Math.abs(n-nums[mid+1]));
        }
        else if (diff<0 && mid>0){
            return Math.min(-diff, Math.abs(n-nums[mid-1]));
        }
        else return Math.abs(diff);
    }
}
