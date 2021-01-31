package Math;

import java.util.HashMap;

public class lc454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer>abMap=new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum=A[i]+B[j];
                if (abMap.containsKey(sum))abMap.replace(sum, abMap.get(sum)+1);
                else abMap.put(sum, 1);
            }
        }
        int count=0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum2=-(C[i]+D[j]);
                count+=abMap.containsKey(sum2)?abMap.get(sum2):0;
            }
        }
        return count;
    }
}
