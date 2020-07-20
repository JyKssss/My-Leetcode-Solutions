package Array;

import java.util.TreeSet;

public class lc220 {
    /**
     * TreeSet方法
     * ts.ceiling(i)
     * ts.floor(i)
     * 分别是大于i的最小值 和小于i的最大值
     * 滑动窗口控制K
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long>treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long value=nums[i];
            if (i-k>0)treeSet.remove((long)nums[i-k-1]);
            Long ceil=treeSet.ceiling(value);
            Long floor=treeSet.floor(value);
            if (ceil!=null && ceil-value<=t){
                return true;
            }
            if (floor!=null && value-floor<=t){
                return true;
            }

            treeSet.add((long)nums[i]);
        }
        return false;
    }
}
