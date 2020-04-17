package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc56 {
    /**
     * 对二维数组按第一位（起点）值进行排序 后面遍历一次即可
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0)return intervals;
        Arrays.sort(intervals,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0]-o2[0];
                    }
                });
        List<int[]> res=new ArrayList<>();
        int preStart=intervals[0][0],preEnd=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart=intervals[i][0];
            int curEnd=intervals[i][1];
            if (preEnd>=curStart){
                preEnd=preEnd>=curEnd?preEnd:curEnd;
                continue;
            }
            else {
                res.add(new int[] {preStart,preEnd});
                preStart=curStart;
                preEnd=curEnd;
            }
        }
        res.add(new int[] {preStart,preEnd});
        int result[][] =new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        res.clear();
        return result;
    }
}
