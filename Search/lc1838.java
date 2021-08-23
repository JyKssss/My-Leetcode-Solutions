package Search;

import java.util.Arrays;

public class lc1838 {
    public int maxFrequency(int[] nums, int k) {
        int[] preSum=new int[nums.length];
        int maxFreq=0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            preSum[i]=i>0?preSum[i-1]+nums[i]:nums[i];
            maxFreq=Math.max(maxFreq, BinarySearch(nums, preSum, i, k));
        }
        return maxFreq;
    }

    private int BinarySearch(int[] nums,int[] preSum, int cur, int k){
        int start=0,end=cur-1,pivot,target=nums[cur],cnt,mid;
        while (start<=end){
            mid=start+(end-start)/2;
            pivot=(cur-mid)*target-(preSum[cur-1]-(mid==0?0:preSum[mid-1]));
            if (pivot<=k){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return cur-start+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,4};
        int k=5;
        lc1838 obj=new lc1838();
        System.out.println(obj.maxFrequency(nums, k));
    }
}
