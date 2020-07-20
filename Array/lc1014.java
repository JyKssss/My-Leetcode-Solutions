package Array;

public class lc1014 {
    //Ai+Aj+i-j=(Ai+i)+(Aj-j)分开求最大值 保证i<j
    public int maxScoreSightseeingPair(int[] A) {
        int maxLeft=0,res=0;
        for (int i = 0; i < A.length; i++) {
            res=Math.max(res, maxLeft+A[i]-i);
            maxLeft=Math.max(maxLeft, A[i]+i);
        }
        return res;
    }
}
