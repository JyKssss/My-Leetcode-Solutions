package Array;

public class lc1004 {



    public int longestOnes(int[] A, int K) {
        int zeroCnt=0,len=A.length,res=0,left=0,right=0;
        while (right<len){
            int cur=A[right];
            right++;
            if (cur==0){
                zeroCnt++;
            }
            while (zeroCnt>K){
                if (A[left]==0){
                    zeroCnt--;
                }
                left++;
            }
            res=Math.max(res, right-left);
        }
        return res;
    }
}
