package Array;

public class lc643 {
    public double findMaxAverage(int[] nums, int k) {
        int total=0,maxTotal=0;
        for (int i = 0; i < k; i++) {
            total+=nums[i];
        }
        maxTotal=total;
        for (int i = k; i <nums.length ; i++) {
            total+=nums[i];
            total-=nums[i-k];
            maxTotal=Math.max(maxTotal, total);
        }
        return (double)(maxTotal)/k;
    }
}
