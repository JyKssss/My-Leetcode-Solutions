package Matrix;

public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int xLen=matrix[0].length,yLen=matrix.length;
        int xr=xLen-1,yr=0,xl=0,yl=yLen-1;
        while (xl<=xr&&yr<=yl){
            if (matrix[yr][xr]>target){
                xr--;
            }
            else if (matrix[yr][xr]<target){
                yr++;
            }
            else return true;

            if (matrix[yl][xl]>target){
                yl--;
            }
            else if (matrix[yl][xl]<target){
                xl++;
            }
            else return true;
            if (xl==xr&&yl==yr)break;
//            System.out.println("xl "+xl+" yl "+yl+" xr "+xr+" yr "+yr);

        }
        if (xl<0||xr<0||yl<0||yr<0||xl>=xLen||xr>=xLen||yl>=yLen||yr>=yLen)return false;
        return target==matrix[yl][xl];
    }
}
