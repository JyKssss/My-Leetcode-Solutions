package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]>heap=new PriorityQueue<>((o1, o2) ->
                o1[1]==o2[1]? o1[0]-o2[0]:o1[1]-o2[1]);

        for (int i = 0; i < mat.length; i++) {
            int[] cur=mat[i];
            int start=0, end=cur.length-1,mid,cnt=0;
            while (start<=end){
                mid=start+(end-start)/2;
                if (cur[mid]==1){
                    cnt=mid+1;
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
            heap.offer(new int[]{i,cnt});
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=heap.poll()[0];
        }
        return res;
    }
}
