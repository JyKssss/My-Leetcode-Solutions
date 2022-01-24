package Array;

public class lc1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(preSum(nums, mid) >= k) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int rank;
        if (index == -1) {
            rank = preSum(nums, nums.length - 1);
            return (k - rank) + nums[nums.length - 1];
        }
        rank = preSum(nums, index);
        return nums[index] - (rank - k + 1);
    }

    private int preSum(int[] nums, int index) {
        int start = nums[0];
        int cur = nums[index];
        return cur - start - index;
    }
}
