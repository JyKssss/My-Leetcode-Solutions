package Math;

public class lc136 {
    /**
     * 异或运算 ^
     * 0^x=x
     * x^x=0
     * 符合交换律
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res ^=nums[i];
        }
        return res;
    }
}
