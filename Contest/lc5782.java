package Contest;

public class lc5782 {
    public long maxAlternatingSum(int[] nums) {
        int len= nums.length;
        long[][] endMax= new long[nums.length+1][2];//0 + 1 -
        endMax[1][0]=nums[0];
        endMax[1][1]=Integer.MIN_VALUE;
        for (int i = 2; i <= nums.length ; i++) {
            endMax[i][0]=Math.max(endMax[i-1][0],Math.max(nums[i-1], endMax[i-1][1]+nums[i-1]));
            endMax[i][1]=Math.max(endMax[i-1][1],endMax[i-1][0]-nums[i-1]);
        }
        return Math.max(endMax[len][0],endMax[len][1]);
    }
}
