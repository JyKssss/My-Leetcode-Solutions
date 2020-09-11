package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        PriorityQueue<number>smallHeap=new PriorityQueue<>(new Comparator<number>() {
            @Override
            public int compare(number o1, number o2) {
                return o1.count-o2.count;
            }
        });
        for(Integer num:nums){
            if (freq.containsKey(num)){
                freq.replace(num, freq.get(num)+1);
            }else freq.put(num, 1);
        }
        for(Integer key:freq.keySet()){
            int count=freq.get(key);
            if (smallHeap.size()<k)smallHeap.offer(new number(key, count));
            else if (smallHeap.peek().count<count){
                smallHeap.poll();
                smallHeap.offer(new number(key, count));
            }
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=smallHeap.poll().val;
        }
        return res;
    }

    class number{
        int val;
        int count;

        public number(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
