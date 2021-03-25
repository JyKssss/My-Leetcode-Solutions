package Math;

public class lc191 {
    /**
     * 无符号补位
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int cnt=0;
        while (n!=0){
            cnt+=(n&1);
            n=n>>>1;
        }
        return cnt;
    }
}
