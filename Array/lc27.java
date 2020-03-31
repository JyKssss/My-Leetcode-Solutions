package Array;

public class lc27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int p=0;
        int q=nums.length-1;
        while (p<q){
            if (nums[p]!=val){
                p++;
            }
            else if (nums[p]==val){
                int r =nums[q];
                nums[p]=r;
                q--;

            }
        }
        if(nums[p]!=val){
            return q+1;
        }
        else{
            return q;
        }

    }

}
