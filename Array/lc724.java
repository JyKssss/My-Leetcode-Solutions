package Array;

public class lc724 {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int i:nums)total+=i;
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            if (left*2+nums[i]==total)return i;
            else left+=nums[i];
        }
        return -1;
    }
}
