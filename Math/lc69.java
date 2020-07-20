package Math;

public class lc69 {
    public int mySqrt(int x) {
        long target=x;
        long var=x;
        while (var*var-x>0.00001){
            var=(var+target/var)/2;
        }
        return (int)var;
    }
}
