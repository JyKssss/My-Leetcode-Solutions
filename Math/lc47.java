package Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>line=new ArrayList<>();
        boolean[] visited=new boolean[len];
        Set<List<Integer>>set=new HashSet<>();
        dfs(0, nums, visited, set, line);
        for(List<Integer>l:set)res.add(l);
        return res;
    }
    public void dfs(int index, int[] nums,boolean[] visited, Set<List<Integer>>set, List<Integer>line){
        if (index==nums.length){
            set.add(new ArrayList<>(line));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]==false){
                line.add(nums[i]);
                visited[i]=true;
                dfs(index+1, nums,visited,set,line );
                line.remove(line.size()-1);
                visited[i]=false;
            }
        }
    }
}
