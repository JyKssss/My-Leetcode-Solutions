package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lc743 {
    //Dijkstra算法
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix=new int[n+1][n+1];
        HashMap<Integer,Integer> res=new HashMap<>();
        for (int[] ints : matrix) {
            Arrays.fill(ints, -1);
        }
        for (int[] time : times) {
            matrix[time[0]][time[1]]=time[2];
        }

        PriorityQueue<int[]>edgesHeap=new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        edgesHeap.offer(new int[]{k,0});
        while (!edgesHeap.isEmpty()){
            int[] curEdge=edgesHeap.poll();
            int node=curEdge[0],time=curEdge[1];
            if (res.containsKey(node)){
                continue;
            }
            res.put(node,time);
            for (int j = 1; j <=n ; j++) {
                if (matrix[node][j]!=-1 && !res.containsKey(j)){
                    edgesHeap.offer(new int[]{j,curEdge[1]+matrix[curEdge[0]][j]});
                }
            }
        }

        int max=0;
//        System.out.println(res.size());
        if (res.size()<n){
            return -1;
        }
        for (Integer time : res.values()) {
            max=Math.max(max, time);
        }
        return max;
    }

    public static void main(String[] args) {
        lc743 obj=new lc743();
        int[][] time=new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n=4,k=2;
        System.out.println(obj.networkDelayTime(time, n, k));
    }
}
