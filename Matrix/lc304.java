package Matrix;

public class lc304 {
    class NumMatrix {
        int[][] matrix;
        int[][] preSumMat;
        boolean isEmpty;
        public NumMatrix(int[][] matrix) {
            if (matrix.length==0||matrix[0].length==0){
                isEmpty=true;
                return;
            }
            else {
                isEmpty=false;
            }
            this.matrix=matrix;
            this.preSumMat=new int[matrix.length+1][matrix[0].length+1];
            for (int i = 1; i <= matrix.length ; i++) {
                for (int j = 1; j <=matrix[0].length ; j++) {
                    preSumMat[i][j]=preSumMat[i-1][j]+preSumMat[i][j-1]+matrix[i-1][j-1]-preSumMat[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (isEmpty){
                return 0;
            }
            return preSumMat[row2+1][col2+1]-preSumMat[row2+1][col1]-preSumMat[row1][col2+1]+preSumMat[row1][col1];
        }
    }
}
