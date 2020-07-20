package Math;

public class lc991 {
    public int brokenCalc(int X, int Y) {
        int count=0;
        while (Y>X){
            if (Y%2==1)Y++;
            else Y=Y/2;
            count++;
        }
        count+=X-Y;
        return count;
    }
}
