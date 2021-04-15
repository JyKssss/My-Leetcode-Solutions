package DynamicProgramming;

public class lc801 {
    public int minSwap(int[] A, int[] B) {
        int nonSwap1=0,swap1=1;
        for (int i = 1; i <A.length ; i++) {
            int nonSwap2=Integer.MAX_VALUE,swap2=Integer.MAX_VALUE;
            if (A[i-1]<A[i]&&B[i-1]<B[i]){
                nonSwap2=Math.min(nonSwap2, nonSwap1);
                swap2=Math.min(swap2, swap1+1);
            }
            if (A[i-1]<B[i]&&B[i-1]<A[i]){
                nonSwap2=Math.min(nonSwap2, swap1);
                swap2=Math.min(swap2, nonSwap1+1);
            }
            nonSwap1=nonSwap2;
            swap1=swap2;
        }
        return Math.min(swap1, nonSwap1);
    }
}
