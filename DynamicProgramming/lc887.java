package DynamicProgramming;

import javafx.util.Pair;

import java.util.HashMap;

public class lc887 {
    int[][]dpTable;
    public int superEggDrop(int K, int N) {
        this.dpTable=new int[K+1][N+1];

        return dp(K, N);
    }

    public int dp(int K, int N){
        if (K==1)return N;
        if (N==0)return 0;
        int res=Integer.MAX_VALUE;

        if (dpTable[K][N]>0){
            return dpTable[K][N];
        }
        //线性搜索
//        for (int i = 1; i <=N ; i++) {
//            res=Math.min(res,
//                    Math.max(dp(K, N-i),
//                            dp(K-1, i-1))+1);
//        }

        //二分搜索提高效率
        int l=1,r=N;
        while (l<=r){
            int mid=l+(r-l)/2;
            int up=dp(K, N-mid),down=dp(K-1,mid-1);
            if (down<up){
                l=mid+1;
                res=Math.min(res, up+1);
            }
            else {
                r=mid-1;
                res=Math.min(res, down+1);
            }

        }
        dpTable[K][N]=res;
        return res;
    }
}
