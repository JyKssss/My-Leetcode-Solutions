package Array;

import java.util.ArrayList;
import java.util.List;

public class lc442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>res=new ArrayList<>();
        int len=nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i]-1)%len]+=len;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>2*len)res.add(i+1);
        }
        return res;
    }
}
