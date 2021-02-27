package Matrix;

public class lc766 {
    int yLen, xLen;
    public boolean isToeplitzMatrix(int[][] matrix) {
        yLen= matrix.length;
        xLen=matrix[0].length;
        for (int i = 0; i < xLen; i++) {
            if (!verifyDiagonal(matrix, yLen-1, i, matrix[yLen-1][i])){
                return false;
            }
        }
        for (int i = 0; i < yLen; i++) {
            if (!verifyDiagonal(matrix, i, xLen-1, matrix[i][xLen-1])){
                return false;
            }
        }
        return true;
    }

    public boolean verifyDiagonal(int[][] matrix,int y,int x,int target){
        if (matrix[y][x]!=target){
            return false;
        }
        else {
            if (x-1>=0 && y-1>=0){
                return verifyDiagonal(matrix, y-1, x-1, target);
            }
            else return true;
        }
    }
}
