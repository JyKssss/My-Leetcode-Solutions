package Math;

public class lc1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] preSum=new long[candiesCount.length];
        boolean[] res=new boolean[queries.length];
        int favoriteTypei; long favoriteDayi, dailyCapi;
        for (int i = 1; i < candiesCount.length ; i++) {
            preSum[i]=preSum[i-1]+candiesCount[i-1];
        }

        for (int i = 0; i < queries.length; i++) {
            favoriteTypei=queries[i][0];
            favoriteDayi=queries[i][1];
            dailyCapi=queries[i][2];

            if (favoriteDayi>=preSum[favoriteTypei]/dailyCapi && favoriteDayi<=preSum[favoriteTypei]+candiesCount[favoriteTypei]-1){
                res[i]=true;
            }
            else {
                res[i]=false;
            }

        }
        return res;
    }
}
