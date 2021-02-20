package Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lc1438 {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int left=0,right=0,maxLen=0;
        HashMap<Integer,Integer>cntMap=new HashMap<>();
        while (right<nums.length){
            minHeap.offer(nums[right]);
            maxHeap.offer(nums[right]);
            if (cntMap.containsKey(nums[right])) {
                cntMap.put(nums[right], cntMap.get(nums[right]) + 1);
            } else {
                cntMap.put(nums[right], 1);
            }
            int sub=Math.abs(getTop(cntMap, maxHeap)-getTop(cntMap, minHeap));
            while (sub>limit&&left<right){
                cntMap.put(nums[left],cntMap.get(nums[left])-1 );
                sub=Math.abs(getTop(cntMap, maxHeap)-getTop(cntMap, minHeap));
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public int getTop(HashMap<Integer,Integer>existMap,PriorityQueue<Integer>heap){
        while (existMap.get(heap.peek())==0){
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        lc1438 obj=new lc1438();
        int[] nums=new int[]{8,2,4,7};
        int limit=4;
        System.out.println(obj.longestSubarray(nums, limit));

    }
}
