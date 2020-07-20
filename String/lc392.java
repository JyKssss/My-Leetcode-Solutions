package String;

public class lc392 {
    public boolean isSubsequence(String s, String t) {
        int lens=s.length(),lent=t.length(),sindex=0,tindex=0;
        while (sindex<lens&&tindex<lent){
            if (s.charAt(sindex)==t.charAt(tindex)){
                sindex++;
            }
            tindex++;
        }
        return sindex==lens;
    }
}
