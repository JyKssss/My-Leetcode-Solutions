package DynamicProgramming;

import java.util.HashMap;

public class lc1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //二维前缀和
        int rowLen=matrix[0].length,colLen=matrix.length,count=0;
        //起始列
        for (int i = 0; i <rowLen ; i++) {
            int[] rowSum=new int[colLen];
            //终止列
            for (int j = i; j <rowLen ; j++) {
                for (int k = 0; k < colLen; k++) {
                    rowSum[k]+=matrix[k][j];
                }
                count+=countTarget(rowSum, target);
            }
        }
        return count;
    }

    private int countTarget(int[] row, int target){
        HashMap<Integer,Integer>preSumCntMap= new HashMap<>();
        preSumCntMap.put(0, 1);
        int preSum=0,count=0;
        for (int i : row) {
            preSum+=i;
            count+=preSumCntMap.getOrDefault(preSum-target, 0);
            preSumCntMap.put(preSum, preSumCntMap.getOrDefault(preSum, 0)+1);
        }
        return count;
    }
}
