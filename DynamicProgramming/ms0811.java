package DynamicProgramming;

public class ms0811 {
    /**
     * 四种币值 1 5 10 25
     * 动态规划 Dij =D(i-1)j +Di(j-1) i表示使用前i种硬币 j表示目标值
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[][] res=new int[4][n+1];
        int[] vals={1,5,10,25};
        for (int i = 0; i < 4; i++) {
            res[i][0]=1;
        }
        for (int i = 1; i < n+1; i++) {
            res[0][i]=1;
        }
        for (int i = 1; i <4 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                res[i][j]=res[i-1][j]%1000000007;
                if (j>=vals[i]){
                    res[i][j]+=res[i][j-vals[i]]%1000000007;
                }
            }
        }
        return res[3][n];
    }
}
