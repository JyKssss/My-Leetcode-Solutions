package Array;

public class lc34 {
    /**
     * 两次二分法查找 分别查找头尾索引
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1,indexStart=-1,indexEnd=-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (nums[mid]>target)end=mid-1;
            else if (nums[mid]<target)start=mid+1;
            else {
                if (mid==0||nums[mid-1]<target){
                    indexStart=mid;
                    break;
                }
                else end=mid-1;
            }
        }
        start=0;
        end=nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (nums[mid]>target)end=mid-1;
            else if (nums[mid]<target)start=mid+1;
            else {
                if (mid==nums.length-1||nums[mid+1]>target){
                    indexEnd=mid;
                    break;
                }
                else start=mid+1;
            }
        }
        int[] res={indexStart,indexEnd};
        return res;
    }
}
