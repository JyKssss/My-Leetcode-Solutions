package Math;

public class lc231 {
    public boolean isPowerOfTwo(int n) {
        while (n>0){
            if ((n&1) ==1){
                return n==1;
            }else {
                n=n>>1;
            }
        }
        return true;
    }
}
