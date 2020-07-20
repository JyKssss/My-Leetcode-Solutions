package Array;

import java.util.ArrayList;
import java.util.List;

public class lc229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<>();
        if (nums==null||nums.length==0)return res;
        int cand1=0,cand2=0,count1=0,count2=0;
        for(int num:nums){
            if (num==cand1){
                count1++;
                continue;
            }
            if (num==cand2){
                count2++;
                continue;
            }
            if (count1==0){
                cand1=num;
                count1++;
                continue;
            }
            if (count2==0){
                cand2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1=count2=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==cand1)count1++;
            else if (nums[i]==cand2)count2++;
        }
        if (count1>nums.length/3)res.add(cand1);
        if (count2>nums.length/3)res.add(cand2);
        return res;
    }
}
