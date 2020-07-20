package Array;

public class lc1004 {
    public int longestOnes(int[] A, int K) {
        int zeroCounts=0,left=0,right=0,maxLen=0;
        while (right<A.length){
            int r=A[right];
            right++;
            if (r==0){
                zeroCounts++;
            }
            while (zeroCounts>K){
                int l=A[left];
                left++;
                if (l==0)zeroCounts--;
            }
            maxLen=maxLen<(right-left)?(right-left):maxLen;
        }
        return maxLen;
    }
}
