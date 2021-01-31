package Math;

import java.util.ArrayList;
import java.util.List;

public class lc1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int remainder=0;
        List<Boolean> res=new ArrayList<>();
        for(int i:A){
            remainder=(remainder*2+i)%5;
            if (remainder==0)res.add(Boolean.TRUE);
            else res.add(Boolean.FALSE);
        }
        return res;
    }
}
