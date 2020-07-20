package Math;

public class lc50 {
    public double myPow(double x, int n) {
        if (n==0)return 1;
        if (n==1)return x;
        int power=Math.abs(n);
        double half=myPow(x, power/2);
        if (n>=0){
            if (n%2==1){
                return half*half*x;
            }
            else return half*half;
        }
        else {
            if (n%2==1){
                return 1/(half*half*x);
            }
            else return 1/(half*half);
        }
    }

    public static void main(String[] args) {
        lc50 l=new lc50();
        System.out.println(l.myPow(2.4, -2));
    }
}
