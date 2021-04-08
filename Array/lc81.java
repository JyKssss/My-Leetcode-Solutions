package Array;

public class lc81 {
    /**
     * 图解法 分成两类的递增mid前和mid后 因为存在相同元素所以用while去重(start和mid)
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums.length==0)return false;
        if (nums[0]==target)return true;
        int start=0,end=nums.length-1;
        if (nums[end]<target &&nums[start]>target)return false;

        while (start<end){
            int mid=(start+end)/2;
            if (nums[mid]==target)return true;
            else if (nums[start]==target)return true;
            else if (nums[end]==target)return true;
            if (nums[start]==nums[mid]){
                start++;
                continue;
            }
            if (nums[mid]>nums[start]){
                if (nums[start]>target||nums[mid]<target){
                    start=mid+1;
                }
                else if (nums[start]<target&&nums[mid]>target){
                    end=mid-1;
                }
            }
            else if (nums[mid]<nums[start]){
                if (nums[start]<target||nums[mid]>target){
                    end=mid-1;
                }
                else if (nums[mid]<target&&nums[start]>target){
                    start=mid+1;
                }
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int start=0, end = nums.length-1,mid;
        while (start<=end){
            mid=start+(end-start)/2;
            int cur=nums[mid];
            if (nums[mid]==target){
                return true;
            }
            if (nums[mid]==nums[start]){
                start++;
                continue;
            }

            if (nums[start]<nums[mid]){
                if (target<cur&&target>=nums[start]){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
            else {
                if (target>cur&&target<=nums[end]){
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
        }
        return false;
    }
}
