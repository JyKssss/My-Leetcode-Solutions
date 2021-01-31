package GreedyAlgo;

import java.util.Arrays;

public class lc135 {
    public int candy(int[] ratings) {
        int total=0;
        int [] candys=new int[ratings.length];
        Arrays.fill(candys, 1);
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i+1]> ratings[i]){
                candys[i+1]=candys[i]+1;
            }
        }

        for (int i = ratings.length-2; i >=0 ; i--) {
            if (ratings[i]> ratings[i+1]){
                candys[i]=Math.max(candys[i], candys[i+1]+1);
            }

        }
        for(int candy:candys)total+=candy;
        return total;
    }
}
