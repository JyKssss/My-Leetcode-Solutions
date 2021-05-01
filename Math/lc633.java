package Math;

public class lc633 {
    public boolean judgeSquareSum(int c) {
        int i=0,j= (int) Math.sqrt(c);
        while (i<=j){
            int i2=i*i,j2=j*j;
            if (i2+j2<c){
                i++;
            }
            else if (i2+j2==c){
                return true;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
