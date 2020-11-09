package Array;

public class lc327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum=new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i>0)preSum[i]=preSum[i-1]+nums[i];
            else preSum[i]=nums[i];
        }
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <nums.length ; j++) {
                long range;
                if (i==0)range=preSum[j];
                else range=preSum[j]-preSum[i-1];
                if (range>=lower&&range<=upper)count++;
            }
        }
        return count;
    }
}
