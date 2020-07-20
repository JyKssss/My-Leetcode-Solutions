package Array;

public class lc287 {
    /**
     * 二分查找
     * 每一次遍历后计数  小于等于n的数量大于n时则重复数在n以及n以前
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int max=nums.length-1,min=1,mid=0;
        while (min<max){
            mid=(max+min)/2;
            int count=0;
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]<=mid)count++;
            }
            if (count>mid){
                max=mid;
            }
            else min=mid+1;
        }
        return max;
    }
}
