package Math;

public class lc837 {
    public double new21Game(int N, int K, int W) {
        if (N>=K+W-1||K==0)return 1;
        if (N<K)return 0;
        double[] probablity=new double[K+W+1];
        for (int i = K+W-1; i >=K ; i--) {
            if (i>N)probablity[i]=0;
            else probablity[i]=1;
        }
        for (int i = K-1; i >=0 ; i--) {
            double pro=0;
            if (i==K-1){
                for (int j = 0; j < W; j++) {
                    pro+=(probablity[i+j+1]/W);
                }
            }
            else {
                pro=((W+1)*probablity[i+1]-probablity[i+1+W])/W;
            }
            probablity[i]=pro;
        }
        return probablity[0];
    }
}
