package Math;

public class lc593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] p1p2={p2[0]-p1[0],p2[1]-p1[1]}, p1p3={p3[0]-p1[0],p3[1]-p1[1]}, p1p4={p4[0]-p1[0],p4[1]-p1[1]};
        if (dotMultply(p1p2, p1p3)==0){
            return len2(p1p2)==len2(p1p3)&&len2(p1p2)>0&&len2(p1p4)==len2(p1p2)*2&&dotMultply(p1p4, p1p2)>0&&dotMultply(p1p4, p1p3)>0;
        }
        else if (dotMultply(p1p2, p1p4)==0){
            return len2(p1p2)==len2(p1p4)&&len2(p1p2)>0&&len2(p1p3)==len2(p1p2)*2&&dotMultply(p1p3, p1p2)>0&&dotMultply(p1p4, p1p3)>0;
        }
        else if (dotMultply(p1p3, p1p4)==0){
            return len2(p1p4)==len2(p1p3)&&len2(p1p3)>0&&len2(p1p2)==len2(p1p3)*2&&dotMultply(p1p4, p1p2)>0&&dotMultply(p1p3, p1p2)>0;
        }
        else return false;
    }
    public int dotMultply(int[] p1,int[] p2){
        return p1[0]*p2[0]+p1[1]*p2[1];
    }
    public int len2(int[] p){
        return p[0]*p[0]+p[1]*p[1];
    }
}

