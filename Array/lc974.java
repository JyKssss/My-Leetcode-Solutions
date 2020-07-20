package Array;

public class lc974 {
    /**
     * 前缀和
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        int[]countK=new int[K];
        int sum=0,count=0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if (sum%K>=0)countK[sum%K]++;
            else {
                countK[sum%K+K]++;
            }
        }
        for (int i = 0; i < countK.length; i++) {
            if (countK[i]>=2){
                count+=(countK[i]-1)*countK[i]/2;
            }
        }
        return count+countK[0];
    }
}
