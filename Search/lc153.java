package Search;

public class lc153 {
    public int findMin(int[] nums) {
        int left=0,right= nums.length-1,mid;
        while (left<right){
            mid=left+(right-left)/2;
            int cur=nums[mid];
            if (cur>nums[left]&&cur<nums[right]){
                return nums[left];
            }

            if (cur>nums[right]){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return nums[left];
    }

    //递归解法
    public int findMin2(int[] nums) {
        int left=0,right= nums.length-1;
        return helper(nums, left, right);
    }
    private int helper(int[] nums,int l, int r){
        if (nums[l]<nums[r]||l==r){
            return nums[l];
        }
        int mid=l+(r-l)/2,cur=nums[mid];
        if (cur>nums[r]){
            return helper(nums, mid+1, r);
        }
        else {
            return helper(nums, l, mid);
        }
    }
}
