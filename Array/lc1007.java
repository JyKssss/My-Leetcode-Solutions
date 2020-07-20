package Array;

public class lc1007 {
    /**
     * 注意上下的值都是一样的情况 需要去重
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations(int[] A, int[] B) {
        int[] acount=new int[6];
        int[] bcount=new int[6];
        int target=-1,sameCount=0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]==B[i]){
                acount[A[i]-1]++;
//                target=A[i];
                sameCount++;
                continue;
            }
            acount[A[i]-1]++;
            bcount[B[i]-1]++;
        }

        for (int i = 0; i <acount.length ; i++) {
            if (acount[i]+bcount[i]==A.length){
                return Math.min(acount[i]-sameCount,bcount[i]);
            }
        }
        return -1;
    }
}
