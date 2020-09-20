package Search;

import java.util.ArrayList;
import java.util.List;

public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>line=new ArrayList<>();
        dfs(res, line, 0, nums);
        return res;
    }

    public void dfs(List<List<Integer>>res,List<Integer>line, int index, int[] nums){
        if (index==nums.length){
            res.add(new ArrayList<>(line));
            return;
        }
        line.add(nums[index]);
        dfs(res, line, index+1,nums);
        line.remove(line.size()-1);
        dfs(res, line, index+1,nums);
    }
}
