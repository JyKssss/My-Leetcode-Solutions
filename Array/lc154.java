package Array;

public class lc154 {
    public int findMin(int[] nums) {
        if (nums.length==1)return nums[0];
        int start=0,end=nums.length-1;
        int min=Integer.MAX_VALUE;
        while (start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<min)min=nums[mid];
            if(nums[start]<min)min=nums[start];
            if(nums[end]<min)min=nums[end];
            if (nums[start]==nums[mid]){
                start++;
                continue;
            }
            if (nums[mid]>nums[start]){
                start=mid+1;
            }
            else if (nums[mid]<nums[start]){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return min;
    }
}
