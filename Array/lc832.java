package Array;

public class lc832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
             int left=0,right=A[i].length-1;
             while (left<=right){
                 int tmp=A[i][left]^1;
                 A[i][left]=A[i][right]^1;
                 A[i][right]=tmp;
                 left++;
                 right--;
             }
        }
        return A;
    }
}
