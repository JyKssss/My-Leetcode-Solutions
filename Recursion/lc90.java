package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc90 {
    List<List<Integer>>res;
    boolean[]isSelected;
    int len;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res=new ArrayList<>();
        List<Integer>subset=new ArrayList<>();
        this.len= nums.length;
        this.isSelected=new boolean[len];
        int index=0;
        Arrays.sort(nums);
        helper(nums, 0, subset);
        return res;
    }

    public void helper(int[] nums,int index,List<Integer>subset ){
        if (index==len){
            res.add(new ArrayList<>(subset));
            return;
        }
        int cur=nums[index];
        int pre=index>0?nums[index-1] :-11;
        if (cur!=pre){
            subset.add(cur);
            isSelected[index]=true;
            helper(nums, index+1, subset);
            subset.remove(subset.size()-1);
            isSelected[index]=false;
            helper(nums, index+1, subset);
        }
        else {
            if (index>0&&isSelected[index-1]==false){
                isSelected[index]=false;
                helper(nums, index+1, subset);
            }
            else {
                isSelected[index]=true;
                subset.add(cur);
                helper(nums, index+1, subset);
                subset.remove(subset.size()-1);
                isSelected[index]=false;

                helper(nums, index+1, subset);
            }
        }
    }
}
