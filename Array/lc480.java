package Array;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int upperSize=0,downSize=0,left=0,right=0;
        double[] res=new double[nums.length-k+1];
        //上顶堆 最大值
        PriorityQueue<int[]> upperHeap=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o2[1]-o1[1];
                return o2[1]<o1[1]?-1:o2[1]==o1[1]?0:1;
            }
        });
        //下底堆 最小值
        PriorityQueue<int[]> downHeap=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
                return o2[1]<o1[1]?1:o2[1]==o1[1]?0:-1;
            }
        });
        while (right< nums.length){
            if (right<k){
                if (upperSize==0 && downSize==0){
                    downHeap.offer(new int[]{right,nums[right]});
                    downSize++;
                }
                else {
                    if (nums[right]>=downHeap.peek()[1]){
                        downHeap.offer(new int[]{right,nums[right]});
                        downSize++;
                    }
                    else {
                        upperHeap.offer(new int[]{right,nums[right]});
                        upperSize++;
                    }
                }
            }
            else {
                if (upperSize==downSize){
                    while (upperHeap.size()>0&&upperHeap.peek()[0]<left)upperHeap.poll();
                    while (downHeap.size()>0&&downHeap.peek()[0]<left)downHeap.poll();
                    double mid= ((double) (upperHeap.peek()[1])+(double)(downHeap.peek()[1]))/2;
                    res[left]=mid;
                }
                else if (upperSize>downSize){
                    while (upperHeap.size()>0&&upperHeap.peek()[0]<left)upperHeap.poll();
                    double mid=upperHeap.peek()[1];
                    res[left]=mid;
                }
                else {
                    while (downHeap.size()>0&&downHeap.peek()[0]<left)downHeap.poll();
                    double mid=downHeap.peek()[1];
                    res[left]=mid;
                }
                //插入新值
                if (nums[right]>=downHeap.peek()[1]){
                    downHeap.offer(new int[]{right,nums[right]});
                    downSize++;
                }
                else {
                    upperHeap.offer(new int[]{right,nums[right]});
                    upperSize++;
                }
                //删除旧值
                if (nums[left]>=downHeap.peek()[1]){
                    downSize--;
                    if (downHeap.peek()[0]==left)downHeap.poll();
                }
                else {
                    upperSize--;
                    if (upperHeap.peek()[0]==left)upperHeap.poll();
                }
                left++;
            }
            if (Math.abs(upperSize-downSize)>1){
                if (upperSize>downSize){
                    while (upperHeap.peek()[0]<left){
                        upperHeap.poll();
                    }
                    int[] n=upperHeap.poll();
                    upperSize--;
                    downSize++;
                    downHeap.offer(n);
                }
                else {
                    while (downHeap.peek()[0]<left){
                        downHeap.poll();
                    }
                    downSize--;
                    upperSize++;
                    upperHeap.offer(downHeap.poll());
                }
            }
//            if (right>=k-1)left++;
            right++;
        }
        if (upperSize>downSize)res[left]=upperHeap.peek()[1];
        else if (upperSize<downSize)res[left]=downHeap.peek()[1];
        else res[left]=((double) (upperHeap.peek()[1])+(double)(downHeap.peek()[1]))/2;
        return res;
    }

    public static void main(String[] args) {
        lc480 obj=new lc480();
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        double[] array=obj.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(array));
    }
}
