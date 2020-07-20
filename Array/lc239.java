package Array;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

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
}
