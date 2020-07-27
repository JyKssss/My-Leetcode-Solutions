package Array;

public class lc945 {
    public int minIncrementForUnique(int[] A) {
        if (A==null||A.length<=1)return 0;
        int[] moveArr=new int[40001];
        int max=0;
        for (int i = 0; i < A.length; i++) {
            moveArr[A[i]]++;
            max=Math.max(max, A[i]);
        }
        int count=0;
        for (int i = 0; i <=max; i++) {
            if (moveArr[i]<=1)continue;
            if (moveArr[i]>1){
                count+=moveArr[i]-1;
                moveArr[i+1]+=moveArr[i]-1;
                // System.out.println(i+" : "+moveArr[i]);
            }
        }
        if (moveArr[max+1]>1)count+=((moveArr[max+1]-1)*moveArr[max+1])/2;
        return count;
    }
}
