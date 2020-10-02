package Math;

public class lc338 {
    /**
     * dp 奇数的1的个数只比其前面的偶数多1
     * 偶数的1的个数和其除2（>>1）后的1数量一致
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        for (int i = 1; i <=num; i++) {
            if (i%2==1){
                res[i]=res[i-1]+1;
            }
            else res[i]=res[i>>1];
        }
        return res;
    }
}
