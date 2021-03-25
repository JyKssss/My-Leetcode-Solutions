package Matrix;

public class lc73 {
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix[0].length==0){
            return;
        }
        int m= matrix.length, n=matrix[0].length;
        boolean mZero=false,nZero=false;
        for (int i = 0; i <m ; i++) {
            if (matrix[i][0]==0){
                mZero=true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i]==0){
                nZero=true;
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][i]=0;
                }
            }
        }

        for (int i = 1; i <m ; i++) {
            if (matrix[i][0]==0){
                for (int j = 1; j <n ; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 1; i <n ; i++) {
            if (matrix[0][i]==0){
                for (int j = 1; j <m ; j++) {
                    matrix[j][i]=0;
                }
            }
        }

        if (mZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }

        if (nZero){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
    }

    public void verifySet(int[][] matrix,int m,int n, int x,int y){
        if (matrix[x][y]==0){
            if (x<m-1&&y<n-1){
                if (matrix[x+1][y]!=0&&matrix[x][y+1]!=0){
                    for (int i = x+1; i <m ; i++) {
                        matrix[i][y]=0;
                    }
                    for (int i = y+1; i <n ; i++) {
                        matrix[x][i]=0;
                    }
                }
            }
            else if (x<m-1){
                if (matrix[x+1][y]!=0){
                    for (int i = x+1; i <m ; i++) {
                        matrix[i][y]=0;
                    }
                }
            }
            else if (y<n-1){
                if (matrix[x][y+1]!=0){
                    for (int i = y+1; i <n ; i++) {
                        matrix[x][i]=0;
                    }
                }
            }
        }
        else {
            return;
        }
    }
}
