package GreedyAlgo;

import java.util.Arrays;

public class lc1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0,i=0;
        while (i< costs.length){
            if (coins>=costs[i]){
                coins-=costs[i];
            }
            else {
                break;
            }
            cnt++;
            i++;
        }
        return cnt;
    }
}
