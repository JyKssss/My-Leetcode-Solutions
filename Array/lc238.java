package Array;

public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int[]preM=new int[nums.length];
        int[]backM=new int[nums.length];
        int[]res=new int[nums.length];
        int pre=1, back=1;
        for (int i = 0; i < nums.length; i++) {
            preM[i]=pre;
            backM[nums.length-i-1]=back;
            pre*=nums[i];
            back*=nums[nums.length-1-i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i]=preM[i]*backM[i];
        }
        return res;
    }

    /**
     * 降低空间复杂度
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[]res=new int[nums.length];
        int left=1, right=1;
        for (int i = 0; i < nums.length; i++) {
            res[i]=left;
            left*=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[nums.length-i-1]=res[nums.length-i-1]*right;
            right*=nums[nums.length-i-1];
        }
        return res;

    }
}
