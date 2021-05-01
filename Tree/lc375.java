package Tree;


public class lc375 {

    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for (int j = 1; j <=n ; j++) {
            for (int i = j-1; i >0 ; i--) {
                int min=Integer.MAX_VALUE;
                for (int k = i; k <=j ; k++) {
                    int cur=k;
                    cur+=Math.max(k>i?dp[i][k-1]:0, k<j?dp[k+1][j]:0);
                    min=Math.min(min, cur);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        lc375 obj=new lc375();
        System.out.println(obj.getMoneyAmount(9));
    }
}
