package Math;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class lc150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer>stack=new LinkedList<>();
        int index=0;
        Pattern pattern=Pattern.compile("-{0,1}[0-9]+");
        while (index< tokens.length){
            String cur=tokens[index];
            if (pattern.matcher(cur).matches()){
                stack.addLast(Integer.parseInt(cur));
            }
            else {
                int y=stack.pollLast(),x=stack.pollLast();
                if (cur.equals("+")){
                    stack.addLast(x+y);
                }
                else if (cur.equals("-")){
                    stack.addLast(x-y);
                }
                else if (cur.equals("*")){
                    stack.addLast(x*y);
                }
                else {
                    stack.addLast((int)x/y);
                }
            }
            index++;
        }
        return stack.pollLast();
    }

    public static void main(String[] args) {
        lc150 obj=new lc150();
        String[] strs=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(obj.evalRPN(strs));
    }
}


