package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>>set=new HashSet<>();
        Arrays.sort(candidates);
        List<List<Integer>>res =new ArrayList<>();
        dfs(res, new ArrayList<>(), target, 0, candidates, 0);
        for(List<Integer>combination: res)set.add(combination);
        res=new ArrayList<>();
        for(List<Integer>combination: set)res.add(combination);
        return res;
    }

    public void dfs(List<List<Integer>>res, List<Integer>line, int target, int total,int[] candidates,int index){
        if (total==target){
            res.add(new ArrayList<>(line));
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            int add=candidates[i];
            if (add+total>target)break;
            line.add(add);
            dfs(res, line, target, total+add, candidates, i+1);
            line.remove(line.size()-1);
        }
    }
}
