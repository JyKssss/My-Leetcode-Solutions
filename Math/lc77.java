package Math;

import java.util.ArrayList;
import java.util.List;

public class lc77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res=new ArrayList<>();
        if (n<k || k<=0)return res;
        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void dfs(List<List<Integer>>res, List<Integer>line, int n, int k, int start){
        if (line.size()==k){
            res.add(new ArrayList<>(line));
            return;
        }
        for (int i = start; i <=n ; i++) {
            line.add(i);
            dfs(res, line, n, k, i+1);
            line.remove(line.size()-1);
        }
    }
}
