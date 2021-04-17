package Tree;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeMap TreeSet
 */
public class lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, Integer> orderedMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k > 0) {
                if (orderedMap.get((long)nums[i - k - 1]) == i - k - 1) {
                    orderedMap.remove((long)nums[i - k - 1]);
                }
            }

            Long cur = (long) nums[i], upper = orderedMap.ceilingKey(cur), lower = orderedMap.floorKey(cur);
            if (upper!=null&&upper-cur <= t  ) {
                return true;
            }
            if (lower!=null&&cur-lower <= t){
                return true;
            }


            orderedMap.put((long) nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,5,9,1,5,9};
        int k=2, t=3;
        lc220 obj=new lc220();
        System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
