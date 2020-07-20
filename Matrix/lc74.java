package Matrix;

public class lc74 {
    /**
     * 通过取模运算把问题转换为二分查找问题
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int lenRow=matrix[0].length,lenCol=matrix.length,start=0,end=lenRow*lenCol-1;
        if (target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])return false;
        while (start<=end){
            int mid=(start+end)/2;

            if (target<matrix[mid/lenRow][mid%lenRow]){
                end=mid-1;
            }
            else if (target>matrix[mid/lenRow][mid%lenRow]){
                start=mid+1;
            }
            else return true;
        }
        return false;
    }
}
