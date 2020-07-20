package Array;

public class lc334 {
    /**
     * 判断三元递增序列 min mid保存当前遍历的对象中的最小值和次小值
     * case1 超出mid 则存在这样的序列
     * case2 > min &< mid 更新为更小的mid
     * case3 < min 更新 min 不会影响结果因为最后判断都是在mid上判断
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min =Integer.MAX_VALUE, mid=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<min)min=nums[i];
            else if (nums[i]<mid&&nums[i]>min)mid=nums[i];
            else return true;
        }
        return false;
    }
}
