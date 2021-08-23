package Contest;

import java.util.Arrays;

public class lc5832 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res=new int[nums.length];
        int index=0;
        for (int i = 0; i < nums.length; i+=2) {
            res[i]=nums[index];
            index++;
        }
        if (nums.length%2==0){
            for (int i = nums.length-1; i >=0 ; i-=2) {
                res[i]=nums[index];
                index++;
            }
        }
        else {
            for (int i = nums.length-2; i >=0 ; i-=2) {
                res[i]=nums[index];
                index++;
            }
        }
        return res;
    }
}
