package Array;

import javafx.util.Pair;

public class lc370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diffArray = new int[length];
        for (int[] update : updates) {
            diffArray[update[0]]+=update[2];
            if (update[1]+1<diffArray.length){
                diffArray[update[1]+1]-=update[2];
            }
        }
        int[] res = new int[length];
        res[0] = diffArray[0];
        for (int i = 1; i <diffArray.length ; i++) {
            res[i] = res[i-1] + diffArray[i];
        }
        return res;
    }
}
