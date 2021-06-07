package Math;

public class lc342 {
    public boolean isPowerOfFour(int n) {
        int count=0;
        while (n>0){
            if ((n & 1)== 1){
                if (n!=1){
                    return false;
                }
                else if(count%2==0){
                    return true;
                }
                else {
                    return false;
                }
            }
            n=n>>1;
            count++;
        }
        return false;
    }
}
