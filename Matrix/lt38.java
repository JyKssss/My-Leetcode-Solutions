package Matrix;

public class lt38 {
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        //从左下和右上角开始搜索
        int xl=matrix.length-1, yl=0, xr=0, yr=matrix[0].length-1, cnt=0;
        boolean isLeft=true;
        while (xl>=xr && yr>=yl){
            if (isLeft){
                if (matrix[xl][yl]>target){
                    xl--;
                }
                else if (matrix[xl][yl]<target){
                    yl++;
                }
                else {
                    cnt++;
                    xl--;
                }
                isLeft=false;
            }
            else {
                if (matrix[xr][yr]>target){
                    yr--;
                }
                else if (matrix[xr][yr]<target){
                    xr++;
                }
                else {
                    cnt++;
                    xr++;
                }
                isLeft=true;
            }


        }

        return cnt;
    }
}
