package Array;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口 On做法使用链表的数据结构 Onlogn做法使用堆
 */
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair<Integer,Integer>>window=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        //initialize
        for (int i = 0; i < k; i++) {
            pushToWin(i, nums[i],window);
        }
        for (int i = 0; i <= nums.length-k; i++) {
            if ((window.isEmpty()||window.peekFirst().getValue()<i+k-1)&&i+k-1<nums.length){
                pushToWin(i+k-1, nums[i+k-1],window);
            }
            res[i]=window.peekLast().getKey();
            if (window.peekLast().getValue()==i)window.removeLast();

        }
        return res;
    }

    public void pushToWin(int index,int val,Deque<Pair<Integer,Integer>>window){
        if (window.isEmpty())window.push(new Pair<>(val, index));
        else {
            while (!window.isEmpty()&&window.peekFirst().getKey()<val){
                window.pop();
            }
            window.push(new Pair<>(val, index));
        }
    }
    //使用堆 （优先队列）
    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int[] res=new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(new int[]{nums[i],i});
            if (i>=k-1){
                while (priorityQueue.peek()[1]<=i-k)priorityQueue.poll();
                res[i-k+1]=priorityQueue.peek()[0];
            }
        }
        return res;
    }
}
