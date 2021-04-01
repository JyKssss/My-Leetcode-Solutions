package Math;

public class lc190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for (int i = 0; i <32&&n!=0 ; i++) {
            int cur=n&1;
            res+=cur<<i;
            n=n>>>1;
        }
        return res;
    }
}
