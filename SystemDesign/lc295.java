package SystemDesign;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 两个堆 一个降序 一个升序 保持两个的大小差值为1以内
 */
public class lc295 {
}
class MedianFinder {
    PriorityQueue<Integer>minHeap,maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        this.maxHeap.add(Integer.MIN_VALUE);
        this.minHeap.add(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        int min=minHeap.peek();
        int max=maxHeap.peek();
//        System.out.println(min+" "+max);
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size()>maxHeap.size())maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size()==maxHeap.size()&&minHeap.size()>0){
            return (minHeap.peek()+maxHeap.peek())/2;
        }
        else if (minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else return maxHeap.peek();
    }
}
