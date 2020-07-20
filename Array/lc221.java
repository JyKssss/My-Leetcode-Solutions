package Array;

public class lc221 {
    public int maximalSquare(char[][] matrix) {
        int lenx=matrix.length;
        if (lenx<1)return 0;
        int leny=matrix[0].length;
        if (lenx<1||leny<1)return 0;
        int[][] numMatrix=new int[lenx][leny];
        int maxsize=0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='0'){
                    continue;
                }
                else {
                    if (maxsize==0)maxsize=1;
                    if (i-1>=0&&j-1>=0){
                        int leftup=numMatrix[i-1][j-1];
                        int left=numMatrix[i-1][j];
                        int up=numMatrix[i][j-1];
                        numMatrix[i][j]=(Math.min(Math.min(leftup, left), up)+1);
                        if (numMatrix[i][j]>maxsize)maxsize=numMatrix[i][j];
                    }
                    else {
                        numMatrix[i][j]=1;
                        continue;
                    }
                }
            }
        }
        return maxsize*maxsize;
    }
}
