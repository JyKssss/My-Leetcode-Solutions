package Array;

public class lc845 {
    public int longestMountain(int[] A) {
        int maxLen=0;
        for (int i = 0; i < A.length; i++) {
            int len=0,left,right;
            if (!isPeak(A, i))continue;
            left=i-1;right=i+1;len++;
            while (left>=0&&A[left]<A[left+1]){
                len++;
                left--;
            }
            while (right<=A.length-1&&A[right]<A[right-1]){
                len++;
                right++;
            }
            i=right-1;
            maxLen=Math.max(maxLen, len);
        }
        return maxLen;
    }
    public boolean isPeak(int[] A, int index){
        if (index==0||index==A.length-1)return false;
        return A[index]>A[index-1]&&A[index]>A[index+1];
    }
}
