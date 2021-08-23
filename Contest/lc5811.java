package Contest;

public class lc5811 {
    public int colorTheGrid(int m, int n) {
        int ABCBA=6,ABCBC=6,ABCAB=6,ABCAC=6,ABACA=6,ABACB=6,ABABA=6,ABABC=6,ABCB=6,ABCA=6,ABAC=6,ABAB=6,ABA=6,ABC=6,AB=6,A=3,MOD=1000000007,cnt=0;
        if (m==1){
            long f=A;
            for (int i = 2; i <=n ; i++) {
                f=f*2%MOD;
            }
            cnt= (int) f;
        }
        if (m==2){
            long f=AB;
            for (int i = 2; i <=n ; i++) {
                f=f*3%MOD;
            }
            cnt= (int) f;
        }
        if (m==3){
            long f1=6,f2=6;// abc  aba
            for (int i = 2; i <=n ; i++) {
                long f1n=(2*f1+2*f2)%MOD;
                long f2n=(2*f1+3*f2)%MOD;
                f1=f1n;
                f2=f2n;
            }
            cnt= (int) ((f1+f2)%MOD);
        }
        if (m==4){
            long f1=6,f2=6,f3=6,f4=6;
            for (int i = 2; i <=n ; i++) {
                long f1n=(2*f1+f2+2*f3+2*f4)%MOD;
                long f2n=(f1+2*f2+f3+f4)%MOD;
                long f3n=(2*f1+f2+2*f3+2*f4)%MOD;
                long f4n=(2*f1+f2+2*f3+3*f4)%MOD;
                f1=f1n;
                f2=f2n;
                f3=f3n;
                f4=f4n;
            }
            cnt= (int) ((f1+f2+f3+f4)%MOD);
        }
        if (m==5){
            long f1=6,f2=6,f3=6,f4=6,f5=6,f6=6,f7=6,f8=6;
            for (int i = 2; i <=n ; i++) {
                long f1n=(2*f1+f2+2*f3+2*f4+0*f5+f6+2*f7+2*f8)%MOD;
                long f2n=(f1+2*f2+f3+f4+f5+f6+f7+f8)%MOD;
                long f3n=(2*f1+f2+3*f3+2*f4+0*f5+f6+2*f7+2*f8)%MOD;
                long f4n=(2*f1+f2+2*f3+2*f4+f5+f6+f7+f8)%MOD;
                long f5n=(0*f1+f2+0*f3+f4+2*f5+f6+0*f7+1*f8)%MOD;
                long f6n=(f1+f2+f3+f4+f5+2*f6+f7+f8)%MOD;
                long f7n=(2*f1+f2+2*f3+f4+0*f5+f6+2*f7+1*f8)%MOD;
                long f8n=(2*f1+f2+2*f3+f4+f5+f6+f7+2*f8)%MOD;
                f1=f1n;
                f2=f2n;
                f3=f3n;
                f4=f4n;
                f5=f5n;
                f6=f6n;
                f7=f7n;
                f8=f8n;
            }
            cnt=(int) ((f1+f2+f3+f4+f5+f6+f7+f8)%MOD);
        }

        return cnt;
    }
}
