package DynamicProgramming;

public class lc413 {
    public int numberOfArithmeticSlices(int[] nums) {
        //dp[i][0]表示以i为末尾的等差数列长度  dp[i][1]表示差值
        if (nums.length<3){
            return 0;
        }
        int[][]dp=new int[nums.length][2];
        int diff,count=0;
        dp[1][0]=2;
        dp[1][1]=nums[1]-nums[0];
        for (int i = 2; i <nums.length ; i++) {
            diff=nums[i]-nums[i-1];
            if (diff==dp[i-1][1]){
                dp[i][0]=dp[i-1][0]+1;
            }
            else {
                dp[i][0]=2;
            }
            dp[i][1]=diff;
        }

        for (int i = 2; i <dp.length ; i++) {
            count+=(dp[i][0]-2);
        }
        return count;
    }
}
