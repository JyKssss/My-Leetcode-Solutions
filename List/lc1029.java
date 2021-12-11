package List;

import java.util.Arrays;
import java.util.Comparator;

public class lc1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int totalCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            totalCost += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            totalCost += costs[i][1];
        }
        return totalCost;
    }
}
