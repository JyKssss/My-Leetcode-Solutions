package Array;

import java.util.ArrayList;
import java.util.List;

public class lc448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>res =new ArrayList<>();
        int len=nums.length;
        for(int n:nums){
            n=Math.abs(n);
            if (nums[n-1]>0){
                nums[n-1]=-nums[n-1];
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
