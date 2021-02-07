package Array;

public class lc665 {
    public boolean checkPossibility(int[] nums) {
        int count=0,prev=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]>nums[i+1]){
                if (prev>nums[i+1]){
                    nums[i+1]=nums[i];
                }
                else {
                    nums[i]=nums[i+1];
                }
                count++;
            }
            prev=nums[i];
        }
        return count<2;
    }
}
