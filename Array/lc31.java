package Array;

import java.util.Arrays;

public class lc31 {
    /***
     * 从右向左扫描 找到第一个不满足递增的数然后与他右边比他大的数中的最小值进行交换 后对右边进行排序
     * @param nums
     */
        public static void nextPermutation(int[] nums) {
            int pre = nums[nums.length - 1];
            int cur;
            int index = 0;
            boolean existBigger = false;
            for (int i = nums.length - 1; i >= 0; i--) {
                cur = nums[i];
                if (cur >= pre) {
                    pre = cur;
                    continue;
                } else {
                    index = i;
                    existBigger = true;
                    break;
                }
            }
            if (existBigger) {
                for (int i = nums.length - 1; i > index; i--) {
                    if (nums[i] > nums[index]) {
                        int inter = nums[i];
                        nums[i] = nums[index];
                        nums[index] = inter;
                        break;
                    }
                }
                int swap =  (nums.length + index)/2;
                System.out.println(index+1+" "+swap);
                for (int i = index + 1; i <= swap; i++) {
                    int inter = nums[i];
                    nums[i] = nums[nums.length - (i - index)];
                    nums[nums.length - (i - index)] = inter;
                }
            }
            else if (!existBigger) Arrays.sort(nums);

        }


    public static void main(String[] args) {
        int[] test = {1,3,2};

        nextPermutation(test);
        System.out.println(test[2]);
    }
}