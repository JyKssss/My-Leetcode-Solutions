package Math;

import java.util.HashMap;

public class lc1711 {
    public int countPairs(int[] deliciousness) {
        int mod=1000000007,max=0,res=0;
        for (int i : deliciousness) {
            max=Math.max(max, i);
        }
        max*=2;
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int del : deliciousness) {
            for (int i = 1; i <=max ; i<<=1) {
                int count=map.getOrDefault(i-del, 0);
                res=count>0?(res+count)%mod:res;
            }
            map.put(del, map.getOrDefault(del, 0)+1);
        }
        return res;
    }
}
