package Array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class lc456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length<3){
            return false;
        }
        //维持一个最小值前缀数组
        int min=Integer.MAX_VALUE;
        int[]preMin=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            min=Math.min(min, nums[i]);
            preMin[i]=min;
        }

        //单调栈存2  遍历3
        Deque<Integer>stack=new LinkedList<>();

        for (int i = nums.length-1; i >=0 ; i--) {
            int cur=nums[i];
            if (cur>preMin[i]){
                while (!stack.isEmpty()&&stack.peekLast()<=preMin[i]){
                    stack.pollLast();
                }
                if (!stack.isEmpty()&& stack.peekLast()<cur){
                    return true;
                }
                else {
                    stack.addLast(cur);
                }
            }
        }
        return false;
    }

    /**
     * 用平衡树maintain num2
     */
    public boolean find132pattern2(int[] nums) {
        if (nums.length<3){
            return false;
        }

        int min=nums[0];
        TreeMap<Integer,Integer>tree2=new TreeMap<>();
        for (int i = 2; i < nums.length ; i++) {
            tree2.put(nums[i], tree2.getOrDefault(nums[i],0)+1 );
        }

        for (int i = 1; i <nums.length-1 ; i++) {
            if (nums[i]>min){
                if (tree2.ceilingKey(min+1)!=null&&tree2.ceilingKey(min+1)<nums[i]){
                    return true;
                }
            }
            tree2.put(nums[i+1],tree2.get(nums[i+1])-1 );
            if (tree2.get(nums[i+1])==0){
                tree2.remove(nums[i+1]);
            }
            min=Math.min(min, nums[i]);
        }
        return false;
    }
}
