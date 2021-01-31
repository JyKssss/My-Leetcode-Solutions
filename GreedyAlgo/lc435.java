package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int r=Integer.MIN_VALUE,count=0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int[] interval:intervals){
            if (interval[0]>=r){
                count++;
                r=interval[1];
            }
        }
        return intervals.length-count;
    }
}
