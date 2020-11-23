package GreedyAlgo;

import java.util.*;

public class lc452 {
    public int findMinArrowShots(int[][] points) {
        List<int[]>pointsList=new LinkedList<>();
        for(int[]point:points)pointsList.add(point);
        Collections.sort(pointsList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);//用减法可能溢出
            }
        });
        ListIterator<int[]>it=pointsList.listIterator();
        int count=0;
        while (it.hasNext()){
            int[]point1= it.next();
            int shoot=point1[1];
            count++;
            while (it.hasNext()){
                int[]point2=it.next();
                if (point2[0]<=shoot)continue;
                else {
                    it.previous();
                    break;
                }
            }
        }
        return count;
    }
}
