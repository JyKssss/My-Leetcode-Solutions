package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>stoneHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int s:stones)stoneHeap.offer(s);
        while (stoneHeap.size()>=2){
            int y=stoneHeap.poll();
            int x=stoneHeap.poll();
            if (x==y)continue;
            else stoneHeap.offer(y-x);
        }
        int res=0;
        if (stoneHeap.size()==1)res=stoneHeap.poll();
        return res;
    }
}
