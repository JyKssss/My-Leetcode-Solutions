package String;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc1190 {
    public String reverseParentheses(String s) {
        Deque<Character>stack=new LinkedList<>();
        List<Character>tmpList=new ArrayList<>();
        int k=0;
        while (k<s.length()){
            char cur=s.charAt(k);
            if (cur!=')'){
                stack.addFirst(cur);
            }
            else {
                while (stack.size()>0&&stack.peekFirst()!='('){
                    tmpList.add(stack.poll());
                }
                stack.poll();
                for (Character character : tmpList) {
                    stack.addFirst(character);
                }
                tmpList.clear();
            }
            k++;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while (stack.size()>0){
            stringBuilder.append(stack.poll());
        }
        return stringBuilder.reverse().toString();
    }
}
