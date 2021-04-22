package DynamicProgramming;

import java.util.TreeSet;

public class lc363 {
    /**
     * matrix.length >> matrix[0].length
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowLen=matrix[0].length,colLen=matrix.length,max=Integer.MIN_VALUE;
        //枚举开始列
        for (int i = 0; i < rowLen; i++) {
            int[] sumCol=new int[colLen];
            //枚举终止列
            for (int j = i; j <rowLen ; j++) {
                for (int l = 0; l < colLen; l++) {
                    sumCol[l]+=matrix[l][j];
                }
                max=Math.max(max, findMaxMin(sumCol, k));
            }
        }
        return max;
    }

    private int findMaxMin(int[]sumCol, int k){
        int preSum=0,max=Integer.MIN_VALUE;
        TreeSet<Integer>treeSet=new TreeSet<>();
        treeSet.add(0);
        for (int i = 0; i < sumCol.length; i++) {
            preSum+=sumCol[i];
            int target=preSum-k;
            Integer preInt=treeSet.ceiling(target);
            if (preInt!=null){
                max=Math.max(max, preSum-preInt);
                System.out.printf("Sum: %d, target: %d, PreSum: %d, area %d%n",preSum,target,preInt,preSum-preInt);
            }
            treeSet.add(preSum);
        }
        return max;
    }
}
