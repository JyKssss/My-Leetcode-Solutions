package Array;

import javafx.util.Pair;

import java.util.Stack;

public class lc42 {
    public int trap(int[] height) {
        //pair 高度 坐标
        if (height.length<=2)return 0;
        Stack<Pair<Integer,Integer>> stack=new Stack<>();
        int volume=0;
        for (int i = 0; i < height.length; i++) {
            int h=height[i];
            if (stack.size()==0||stack.peek().getKey()>=h){
                stack.push(new Pair<>(h, i));
                System.out.println("push1: "+h+" "+i);
            }
            else {
                while ((!stack.isEmpty())&&stack.peek().getKey()<h){
                    Pair<Integer,Integer>cur=stack.pop();
                    while (!stack.isEmpty()&&stack.peek().getKey()==cur.getKey()){
                        cur=stack.pop();
                    }
                    int H=Math.min(h, stack.isEmpty()?0:stack.peek().getKey());
                    System.out.println("H: "+H);
                    if (H>0){
                        volume+=(H-cur.getKey())*(i-stack.peek().getValue());
                        System.out.println("vol: "+volume);
                    }
                }
                System.out.println("push2: "+h+" "+i);
                stack.push(new Pair<>(h, i));
            }
        }
        return volume;
    }
}
