package Math;

import java.util.ArrayList;
import java.util.List;

public class lc216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer>nums=new ArrayList<>();
        for (int i = 1; i <=9; i++) {
            nums.add(i);
        }
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>solution=new ArrayList<>();
        dfs(res,nums, solution, n, 0, k, 0, 0);
        return res;
    }

    public void dfs(List<List<Integer>>res,List<Integer>nums,List<Integer>solution,int n, int sum, int k,int num,int index){
        if (n==sum && k==num){
            res.add(new ArrayList<>(solution));
            return;
        }
        if ((n==sum && k!=num)||(n!=sum && k==num)||num>k)return;
        for (int i = index; i <nums.size(); i++) {
            int add=nums.get(i);
            if (sum+add>n)break;
            solution.add(add);
            dfs(res, nums, solution, n, sum+add, k, num+1, i+1);
            solution.remove(solution.size()-1);
        }
    }
}
