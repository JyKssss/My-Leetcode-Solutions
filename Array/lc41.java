package Array;

public class lc41 {
    /**
     * 第一次遍历将在1至nums.length-1范围的数放在一一对应的数组位置上
     * 第二次遍历判断对应位置是不是n+1的数 入圈匹配则最小值为nums.length+1
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums.length-1||nums[i]<=0)continue;
            while (nums[i]>0&&nums[i]<=nums.length-1&&nums[i]!=i+1){

                int tmp=nums[i];
                if (nums[tmp-1]==tmp)break;
                nums[i]=nums[tmp-1];
                nums[tmp-1]=tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1)return i+1;
        }
        return nums.length+1;
    }
}
