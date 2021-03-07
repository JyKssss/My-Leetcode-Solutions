package Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
//        if (nums.length==0)return null;
        int[] res=new int[nums.length];
        Arrays.fill(res, -1);
        int len=nums.length;
        if (len<=1){
            return res;
        }
        int[] circleArr=new int[len*2];
        for (int i = 0; i < circleArr.length; i++) {
            circleArr[i]=nums[i% len];
        }
        Deque<int[]>stack=new LinkedList<>();
        for (int i = 0; i < circleArr.length; i++) {
            int cur=nums[i%len];
            if (stack.isEmpty()||stack.peekLast()[1]>=cur){
                stack.addLast(new int[]{i%len,cur});
            }
            else {
                while (!stack.isEmpty()&&stack.peekLast()[1]<cur){
                    int[] pre=stack.pollLast();
                    res[pre[0]]=cur;
                }
                stack.addLast(new int[]{i%len,cur});
            }
        }
        return res;
    }
}
