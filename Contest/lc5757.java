package Contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc5757 {
    public int[] getBiggestThree(int[][] grid) {
        int col= grid.length, row= grid[0].length,maxDia=Math.min(col, row)%2==0?Math.min(col, row)-1:Math.min(col, row);
        PriorityQueue<Integer>largest3Tri=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return null;

    }
}
