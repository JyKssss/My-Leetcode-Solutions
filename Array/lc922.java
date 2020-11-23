package Array;

public class lc922 {
    public int[] sortArrayByParityII(int[] A) {
        int j=1;
        for (int i = 0; i < A.length; i+=2) {
            if ((A[i]&1)!=0){
                while ((A[j]&1)!=0){
                    j+=2;
                }
                int tmp=A[j];
                A[j]=A[i];
                A[i]=tmp;
            }
        }
        return A;
    }
}
