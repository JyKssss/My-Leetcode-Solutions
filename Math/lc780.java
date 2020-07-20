package Math;

public class lc780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx>=sx&&ty>=sy){
            if (tx==sx&&ty==sy)return true;
            if (tx>ty){
                int n=((tx-sx)/ty);
                if (n==0)n++;
                tx-=ty*n;
            }
            else if (ty>tx){
                int n=((ty-sy)/tx);
                if (n==0)n++;
                ty-=tx*n;
            }
            else return tx==sx&&ty==sy;
        }
        return tx==sx&&ty==sy;
    }

}
