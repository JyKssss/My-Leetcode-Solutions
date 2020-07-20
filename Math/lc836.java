package Math;

public class lc836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (overlap(rec1[0],rec1[2],rec2[0],rec2[2]))&&(overlap(rec1[1],rec1[3],rec2[1],rec2[3]));
    }
    public boolean overlap(int s1,int e1,int s2,int e2){
        return (s1>=s2&&e1<=e2)||(s1>=s2&&s1<e2)||(e1<=e2&&e1>s2)||
                (s2>=s1&&e2<=e1)||(s2>=s1&&s2<e1)||(e2<=e1&&e2>s1);
    }
}
