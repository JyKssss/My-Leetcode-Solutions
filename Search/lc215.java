package Search;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        int target= nums.length-k,len=nums.length;
        divide(nums, 0, len-1, target);
        return nums[target];
    }

    private void divide(int[] nums,int left, int right,int target){
        if (left>=right)return;;
        int random= (int) (left+Math.random()*(right-left));
        swap(nums, right, random);
        int index=partition(nums, left, right);
        if (index==target)return;
        else if (index<target){
            divide(nums, index+1, right, target);
        }
        else {
            divide(nums, left, index-1, target);
        }
    }

    private int partition(int[] nums,int left,int right){
        int pivot=nums[right],wall=left;
        for (int i = left; i <right ; i++) {
            if (nums[i]<pivot){
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }

    private void swap(int[] nums, int p1,int p2){
        int tmp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=tmp;
    }
}
