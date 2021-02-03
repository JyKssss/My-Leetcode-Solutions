package Array;

import java.util.HashSet;

public class lc888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA=0,totalB=0,diff;
        HashSet setA=new HashSet();
        for(int a:A){
            totalA+=a;
            setA.add(a);
        }
        for(int b:B)totalB+=b;
        diff=totalB-totalA;
        diff/=2;
        int[] res=new int[2];
        for(int b:B){
            if (setA.contains(b-diff)){
                res[0]=b-diff;
                res[1]=b;
            }
        }
        return res;
    }
}
