package DynamicProgramming;

public class lc198 {
    /*
    Ai 表示前i个的最大金额  如果Ai-1 = Ai-2 这说明 第i-1个没有被盗窃 Ai =Ai-1 +ai
    反之 Ai =max(Ai-1,Ai-2 +ai)
     */
    public int rob(int[] nums) {
        int pre1,pre2;
        if (nums==null||nums.length==0)return 0;
        if (nums.length==1)return nums[0];
        if (nums.length==2)return Math.max(nums[0],nums[1]);
        pre1=nums[0];
        pre2=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length ; i++) {
            if (pre1==pre2){
                pre2=pre1+nums[i];
            }
            else {
                int inter=pre2;
                pre2=Math.max(pre2, pre1+nums[i]);
                pre1=inter;
            }
        }
        return Math.max(pre1, pre2);
    }
}
