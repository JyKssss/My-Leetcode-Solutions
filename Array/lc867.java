package Array;

public class lc867 {
    public int[][] transpose(int[][] matrix) {
        int[][] resMat=new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resMat[j][i]=matrix[i][j];
            }
        }
        return resMat;
    }
}
