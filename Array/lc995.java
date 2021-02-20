package Array;

public class lc995 {
    /**
     * 长度为N的数组当中存在N-K+1个子数组 可以证明顺次循环当发现目前数为0时就需要翻转这个数开头的数组
     * 使用差分数组计算翻转次数
     * 用异或运算代替二进制加减法
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int flipTimes=0,ans=0;
        int[] diff=new int[A.length+1];
        int i=0;
        while (i< A.length){
            flipTimes^=diff[i];
            if (flipTimes==A[i]){
                if (i+K>=diff.length)return -1;
                ans+=1;
                flipTimes^=1;
                diff[i+K]^=1;
            }
            i++;
        }
        return ans;
    }
}
