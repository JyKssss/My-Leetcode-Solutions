package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> anglesList = new ArrayList<>();
        int extraCnt = 0, pointX = location.get(0), pointY = location.get(1);
        for (List<Integer> point : points) {
            int x = point.get(0), y = point.get(1);
            if (x == pointX && y == pointY) {
                extraCnt += 1;
                continue;
            }
            double curAngle = Math.atan2(y - pointY, x - pointX);
            anglesList.add(curAngle);
            anglesList.add(curAngle + 2 * Math.PI);
        }
        Collections.sort(anglesList);
        double degreeRange = angle * Math.PI /180.0;
        int maxCnt = 0, left = 0, right = 0;
        while (right < anglesList.size()) {
            if (anglesList.get(right) - anglesList.get(left) <= degreeRange) {
                maxCnt = Math.max(maxCnt, right - left + 1);
                right += 1;
            }
            else {
                left += 1;
            }
        }
        return maxCnt + extraCnt;
    }
}
