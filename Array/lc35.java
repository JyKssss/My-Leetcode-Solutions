package Array;

/***
 * 注意边界条件
 */
public class lc35 {

    public int searchInsert(int[] nums, int target) {
        int start,end,mid;
        start=0;
        end=nums.length-1;

        if (nums.length==0)return 0;
        if (target<=nums[0])return 0;
        if (target>nums[end])return end+1;
        if (target==nums[end])return end;
        while (start<end){
            mid=(start+end)/2;
            if (target>nums[end])return end+1;
            if (target<=nums[start])return start;
            if (target==nums[mid])return mid;
            if (target==nums[start])return start;
            if (target==nums[end])return end;
            if (target<nums[mid]){
                end=mid-1;
                if (start==end)return mid;
            }
            else if (target>nums[mid]){
                start=mid+1;
                if (start==end)return end;
            }
        }
        return 0;
    }
}
