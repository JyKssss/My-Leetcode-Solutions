package Search;

import java.util.Arrays;
import java.util.TreeSet;

public class lc475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int heater : heaters) {
            treeSet.add(heater);
        }
        int maxRadius = 0;
        for (int house : houses) {
            Integer leftHeater = treeSet.floor(house);
            Integer rightHeater = treeSet.ceiling(house);
            int r = Integer.MAX_VALUE;
            if (leftHeater != null) {
                r = Math.min(r, house - leftHeater);
            }
            if (rightHeater != null) {
                r = Math.min(r, rightHeater - house);
            }
            maxRadius = Math.max(maxRadius, r);
        }
        return maxRadius;
    }
}
