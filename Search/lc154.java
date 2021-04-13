package Search;

public class lc154 {
    public int findMin(int[] nums) {
        int left=0, right= nums.length-1,mid;
        while (left<right){
            mid=left+(right-left)/2;
            int cur=nums[mid];
            if (cur<nums[right]){
                right=mid;
            }
            else if (cur>nums[right]){
                left=mid+1;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}
