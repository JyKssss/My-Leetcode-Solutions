package Math;

public class lc829 {
    public int consecutiveNumbersSum(int N) {
        int maxK=(int) (Math.sqrt(2*N+0.25)-0.5),count=0;
        for (int i = 1; i <= maxK; i++) {
            if ((2*N-i*i+i)%(2*i)!=0)continue;
            count++;
        }
        return count;
    }
}
