package Search;

public class lc494 {
    int count,target;
    int[] nums;
    public int findTargetSumWays(int[] nums, int target) {
        this.count=0;
        this.target=target;
        this.nums=nums;
        dfs(0, 0);
        return count;
    }

    private void dfs(int index,int sum){
        if (index== nums.length){
            if (target ==sum){
                count++;
            }
            return;
        }
        int cur=nums[index];
        dfs(index+1, sum+cur);
        dfs(index+1, sum-cur);
    }

    /**
     * dp解决 nums总和为sum 其中负数和为negs 则有 sum - 2 * negs =target => (sum-target)/2 = negs
     * dp 寻找和为 negs=(sum-target)/2的元素组合数
     * dp[l][m] 取前l个 和为m的组合数
     * 空间还可以优化
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum=0, negs=0,cur;
        for (int num : nums) {
            sum+=num;
        }
        if (sum-target<0 || (sum-target)%2==1){
            return 0;
        }
        negs=(sum-target)/2;
        int[][] dp=new int[nums.length+1][negs+1];
        dp[0][0]=1;
        for (int i = 1; i <= nums.length ; i++) {
            for (int j = 0; j <=negs ; j++) {
                cur=nums[i-1];
                dp[i][j]=dp[i-1][j];
                if (j-cur>=0){
                    dp[i][j]+=dp[i-1][j-cur];
                }
            }
        }
        return dp[nums.length][negs];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum=0, negs=0,cur;
        for (int num : nums) {
            sum+=num;
        }
        if (sum-target<0 || (sum-target)%2==1){
            return 0;
        }
        negs=(sum-target)/2;
        int[] dp=new int[negs+1];
        dp[0]=1;
        for (int i = 1; i <= nums.length ; i++) {
            for (int j = negs; j >=0 ; j--) {
                cur=nums[i-1];
                dp[j]=dp[j];
                if (j-cur>=0){
                    dp[j]+=dp[j-cur];
                }
            }
        }
        return dp[negs];
    }
}
