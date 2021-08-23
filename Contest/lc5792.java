package Contest;

public class lc5792 {
    public int countTriples(int n) {
        int cnt=0;
        for (int a = 1; a <=n ; a++) {
            for (int b = 1; b <=n ; b++) {
                int c2=a*a+b*b;
                int sqr= (int) Math.sqrt(c2);
                if (sqr*sqr==c2 && sqr<=n){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
