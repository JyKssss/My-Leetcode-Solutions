package Array;

public class lc283 {
    public void moveZeroes(int[] nums) {
        int left=-1,right=0;
        while (right<nums.length){
            if (nums[right]!=0){
                left++;
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                right++;
            }
            else right++;
        }
    }
}
