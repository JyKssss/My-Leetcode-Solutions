package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc703 {

}


class KthLargest {
    int heapSize;
    PriorityQueue<Integer>heap;

    public KthLargest(int k, int[] nums) {
        this.heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        this.heapSize=k;
        for(int n:nums){
            if (heap.size()<k){
                heap.offer(n);
            }
            else {
                if (n<=heap.peek()){
                    continue;
                }
                else {
                    heap.offer(n);
                    heap.poll();
                }
            }
        }
    }

    public int add(int val) {
        this.heap.offer(val);
        if (this.heap.size()>this.heapSize){
            heap.poll();
        }
        return this.heap.peek();
    }
}
