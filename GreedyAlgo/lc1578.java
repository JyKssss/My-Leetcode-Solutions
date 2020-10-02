package GreedyAlgo;

public class lc1578 {
    public int minCost(String s, int[] cost) {
        if (cost.length<=1)return 0;
        char pre=s.charAt(0),cur;
        int index,preIndex=0,minCost=0;
        for ( index = 1; index <cost.length ; index++) {
            cur=s.charAt(index);
            if (cur!=pre){
                pre=cur;
                preIndex=index;
            }
            else {
                int cost1=cost[preIndex],cost2=cost[index];
                if (cost1>cost2){
                    minCost+=cost2;
                }
                else {
                    minCost+=cost1;
                    preIndex=index;
                }
            }
        }
        return minCost;
    }
}
