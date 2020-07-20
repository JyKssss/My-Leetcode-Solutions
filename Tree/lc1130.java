package tree;

public class lc1130 {
    /**
     * 表面上是一个树的问题·实际上是一个标准的DP问题
     * dp[i][j]表示从i到j的最小值
     * max[i][j]表示从i到j的最大叶节点值
     * 状态转移方程 dp[i][j]=min(dp[i][k]+dp[k+1][j]+max[i][k]*max[k+1][j])
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        int length=arr.length;
        int[][] max=new int [length][length];
        for (int i = 0; i < length; i++) {
            int maxVal=arr[i];
            for (int j = i ; j < length; j++) {
                if (maxVal<arr[j]){
                    maxVal=arr[j];
                }
                max[i][j]=maxVal;
            }
        }
        int[][]dp=new int[length][length];
        for (int j = 0; j < length; j++) {
            for (int i = j; i >=0; i--) {
                if (i==j){
                    dp[i][j]=0;
                    continue;
                }
                int min=Integer.MAX_VALUE;
                for (int k = i; k+1 <=j ; k++) {
                    min=Math.min(min, dp[i][k]+dp[k+1][j]+max[i][k]*max[k+1][j]);
                    dp[i][j]=min;
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[0][length-1];
    }
}
