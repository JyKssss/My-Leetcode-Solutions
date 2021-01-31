package GreedyAlgo;

import java.util.Arrays;

public class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0,index=0;
        for (int i = 0; i < g.length; i++) {
            while (index<s.length && s[index]<g[i]){
                index++;
            }
            if (index<s.length && s[index]>=g[i]){
                count++;
                index++;
            }
            if (index>=s.length)break;
        }
        return count;
    }
}
