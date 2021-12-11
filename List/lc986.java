package List;

import java.util.ArrayList;
import java.util.List;

public class lc986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersactionList = new ArrayList<>();
        int index1 = 0, index2 = 0, len1 = firstList.length, len2 = secondList.length;
        while (index1 < len1 && index2 < len2) {
            int[] interval1 = firstList[index1];
            int[] interval2 = secondList[index2];
            int start = Math.max(interval1[0], interval2[0]);
            int end = Math.min(interval1[1], interval2[1]);
            if (start > end) {
                if (interval1[1] < interval2[1]) {
                    index1 += 1;
                }
                else {
                    index2 += 1;
                }
            } else {
                int[] addInterval = new int[]{start, end};
                intersactionList.add(addInterval);
                if (interval1[1] < interval2[1]) {
                    index1 += 1;
                } else if (interval1[1] == interval2[1]){
                    index1 += 1;
                    index2 += 1;
                } else {
                    index2 += 1;
                }
            }
        }
        int[][] res = new int[intersactionList.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersactionList.get(i);
        }
        return res;
    }
}
