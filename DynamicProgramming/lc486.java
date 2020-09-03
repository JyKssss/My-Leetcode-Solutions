package DynamicProgramming;

public class lc486 {
    public boolean PredictTheWinner(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=nums[i];
        }
        for (int i = len-1; i >=0 ; i--) {
            for (int j = i+1; j <len ; j++) {
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][len-1]>=0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int start=0,end=nums.length-1;
        return dfs(nums, 0, end, 1)>=0;
    }
    public int dfs(int[]nums,int start,int end,int t){
        if (start==end){
            return nums[start]*t;
        }
        else {
            int startScore=nums[start]*t+dfs(nums, start+1, end, -t );
            int endScore=nums[end]*t+dfs(nums, start, end-1, -t);
            return Math.max(startScore*t, endScore*t)*t;
        }
    }
}
