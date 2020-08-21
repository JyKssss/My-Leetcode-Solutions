package Array;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class lc632 {
    /**
     * 最大堆和最小堆解决问题
     * @param nums
     * @return
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair<Integer,Integer>>minHeap=new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int [] indexs=new int [nums.size()];
        int minLen=Integer.MAX_VALUE, min=Integer.MAX_VALUE,max=0;
        for (int i = 0; i < nums.size(); i++) {minHeap.add(new Pair<>(nums.get(i).get(0), i));maxHeap.add(nums.get(i).get(0));}
        while (true){
            Pair<Integer,Integer>minPair=minHeap.poll();
            int tmpMin=minPair.getKey(),index=minPair.getValue(),tmpMax=maxHeap.peek();
            if (tmpMax-tmpMin+1<minLen){
                minLen=tmpMax-tmpMin+1;
                min=tmpMin;
                max=tmpMax;
            }
            if (nums.get(index).size()-1>indexs[index]){
                indexs[index]++;
                maxHeap.add(nums.get(index).get(indexs[index]));
                minHeap.add(new Pair<>(nums.get(index).get(indexs[index]),index));
            }
            else break;
        }
        int[] res=new int[]{min,max};
        return res;
    }
}
