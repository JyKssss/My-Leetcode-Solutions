package Array;

public class lc134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0,sum=0,start=0;
        for (int i = 0; i < gas.length; i++) {
            tank=tank+gas[0]-cost[0];
            if (tank<0){
                start=i;
                tank=0;
            }
            sum+=(gas[i]-cost[i]);
        }
        return sum>=0?start:-1;
    }
}
