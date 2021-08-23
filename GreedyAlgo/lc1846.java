package GreedyAlgo;

import java.util.Arrays;

public class lc1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int target=1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>=target){
                target++;
            }
        }
        return target-1;
    }
}
