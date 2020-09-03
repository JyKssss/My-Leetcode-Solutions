package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc491 {
    List<List<Integer>>res;
    List<Integer>temp;
    HashSet<List<Integer>>set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.res=new ArrayList<>();
        this.temp=new ArrayList<>();
        this.set=new HashSet<>();
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    public void dfs(int curIndex,int last, int[]nums){
        if (curIndex==nums.length){
            List<Integer> list=new ArrayList<>(temp);
            if (temp.size()>=2&&!set.contains(list)){
                res.add(list);
                set.add(list);
            }
            return;
        }

        if (nums[curIndex]>=last){
            temp.add(nums[curIndex]);
            dfs(curIndex+1, nums[curIndex],nums);
            temp.remove(temp.size()-1);
        }

        dfs(curIndex+1, last, nums);
        return;
    }
}
