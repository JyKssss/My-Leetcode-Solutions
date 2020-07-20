package Array;

public class lc162 {
    /**
     * 二分查找 大于mid值的一边必定存在峰值（因为左右端点为负无穷）
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length==1)return 0;
        int start=0,end=nums.length-1,mid=0;
        while (start<=end){
            mid=(start+end)/2;
            if (mid>0&&mid<nums.length-1){
                if(nums[mid+1]>nums[mid]){
                    start=mid+1;
                }
                else if(nums[mid-1]>nums[mid]){
                    end=mid-1;
                }
                else return mid;
            }
            else {
                if (mid==0){
                    if (nums[mid+1]>nums[mid])start=mid+1;
                    else return mid;
                }
                else {
                    if (nums[mid-1]>nums[mid])end=mid-1;
                    else return mid;
                }
            }
        }
        return mid;
    }
}
