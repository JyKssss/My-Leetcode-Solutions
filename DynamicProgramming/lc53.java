package DynamicProgramming;

/***
 * dp解法  每一轮找到以i为终点的最大子路
 */
public class lc53 {
    public int maxSubArray(int[] nums) {
        int maxValue=nums[0];
        int subMax=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i==0)continue;
            if (subMax>=0){
                subMax+=nums[i];
            }
            else {
                subMax=nums[i];
            }
            maxValue=Math.max(subMax, maxValue);
        }
        return maxValue;
    }
}
