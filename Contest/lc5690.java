package Contest;

import java.util.LinkedList;

public class lc5690 {
    LinkedList<Integer>res;
    int appendLength;
    int[] toppingCosts;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res=new LinkedList<>();
        appendLength= toppingCosts.length;
        this.toppingCosts=toppingCosts;
        for(int base:baseCosts){
            dfs(base, 0, target);
        }
        return res.get(0);
    }

    public void dfs(int sum,int index,int target){
        if (index==appendLength){
            if (res.size()==0||Math.abs(sum-target)<Math.abs(res.get(0)-target)){
                res.clear();
                res.push(sum);
            }
            else if (Math.abs(sum-target)==Math.abs(res.get(0)-target)&&sum<res.get(0)){
                res.clear();
                res.push(sum);
            }
            return;
        }
        else {
            dfs(sum, index+1, target);
            dfs(sum+toppingCosts[index],index+1,target);
            dfs(sum+2*toppingCosts[index],index+1,target);
        }
    }

}
