package Heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class lc973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (int i = 0; i < points.length; i++) {
            int[] point=new int[2];
            point[0]=i;
            point[1]= (int) (Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            if (queue.size()<K)queue.offer(point);
            else {
                queue.offer(point);
                queue.poll();
            }
        }
        int [][]res=new int[queue.size()][];
        Iterator<int[]> it= queue.iterator();
        for (int i = 0; i < queue.size(); i++) {
            int[] p=it.next();
            res[i]=points[p[0]];
        }
        return res;
    }
}
