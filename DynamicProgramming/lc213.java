package DynamicProgramming;

public class lc213 {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max=0,prev_1=0,prev_2=0,cur=0;
        for (int i = 0; i < nums.length-1; i++) {
            cur=Math.max(prev_1, prev_2+nums[i]);
            prev_2=prev_1;
            prev_1=cur;
        }
        max=Math.max(max, cur);
        prev_1=0;
        prev_2=0;
        for (int i = 1; i < nums.length ; i++) {
            cur=Math.max(prev_1, prev_2+nums[i]);
            prev_2=prev_1;
            prev_1=cur;
        }
        max=Math.max(max, cur);
        return max;
    }
}
