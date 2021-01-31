package DynamicProgramming;

public class lc746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        int[] totalCost=new int[cost.length];
        totalCost[0]=cost[0];
        totalCost[1]=cost[1];
        for (int i = 2; i <cost.length ; i++) {
            totalCost[i]=Math.min(totalCost[i-1],totalCost[i-2])+cost[i];
        }
        return Math.min(totalCost[totalCost.length-1], totalCost[totalCost.length-2]);
    }
}
