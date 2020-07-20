package Matrix;

public class lc498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return new int[0];
        int[] res=new int[matrix.length*matrix[0].length];
        int x=0,y=0,xlen=matrix[0].length,ylen=matrix.length;
        for (int i = 0; i < res.length; i++) {
            if ((x+y)%2==0){
                res[i]=matrix[y][x];
                if (x<xlen-1&&y>0){
                    x++;
                    y--;
                }
                else if (y==0&&x<xlen-1){
                    x++;
                }
                else if (y>0&&x==xlen-1){
                    y++;
                }
                else y++;
            }
            else {
                res[i]=matrix[y][x];
                if (x>0&&y<ylen-1){
                    x--;
                    y++;
                }
                else if (x==0&&y<ylen-1){
                    y++;
                }
                else if (x>0&&y==ylen-1){
                    x++;
                }
                else x++;
            }
        }
        return res;
    }
}
