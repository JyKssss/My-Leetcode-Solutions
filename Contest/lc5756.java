package Contest;

import java.util.Arrays;

public class lc5756 {
    /**
     * 状态压缩dp mask中第i位的0/1表示 nums2[i-1]是否被选择 count(mask)表示nums1被使用个数
     * dp[mask] = min{ dp[mask/i] + nums2[i-1] xor nums1[count-1] }
     * @param nums1
     * @param nums2
     * @return
     */
    public int minimumXORSum1(int[] nums1, int[] nums2) {
        int n=nums1.length,range=1<<n;
        int[] dp=new int[1<<n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for (int mask = 0; mask <range; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i))==(1<<i)){
                    dp[mask]=Math.min(dp[mask], dp[mask^(1<<i)] + (nums1[Integer.bitCount(mask)-1]^nums2[i]));//注意运算符的优先级
                }
            }
        }
        return dp[range-1];
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length, range = 1 << n;
        int[] dp = new int[range];//若i的二进制表示中1的个数为num, 1的位置为k1,k2,...,knum, dp[i]表示nums1的前num个数和nums2第k1,k2,...,knum个数的最小异或值之和
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < range; mask++) {
            for (int i = 0; i < n; i++) {//遍历i的各个二进制位
                if (((mask >> i) & 1) == 1)//i的第j位为1
                    dp[mask] = Math.min(dp[mask], dp[mask ^ (1 << i)] + (nums1[Integer.bitCount(mask) - 1] ^ nums2[i]));//尝试选取nums1[num]和nums2[j]进行异或更新dp[i]
            }
        }
        return dp[range - 1];//答案为dp[111...1](n个1)
    }


    public static void main(String[] args) {
        lc5756 obj=new lc5756();
        int[] nums1=new int[]{1,2}, nums2=new int[]{2,3};
        System.out.println(obj.minimumXORSum(nums1, nums2));
    }
}
