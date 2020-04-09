package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc5376 {
    public List<Integer> minSubsequence(int[] nums) {
        Integer[] numObj=new Integer[nums.length];
        List<Integer>res=new ArrayList<>();
        int sum=0;
        int tmp=0;
        int index;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            numObj[i]=Integer.valueOf(nums[i]);
        }
        Arrays.sort(numObj,Collections.reverseOrder());
        for (int i = 0; i < numObj.length; i++) {
            tmp+=numObj[i];
            res.add(numObj[i]);
            if (tmp>=(sum/2)+1){
                break;
            }
        }
        return res;
    }
}
