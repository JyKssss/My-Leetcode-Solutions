package String;

import java.util.Stack;

public class lc20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charStr=s.charAt(i);
            if (charStr=='('||charStr=='['||charStr=='{'){
                stack.push(charStr);
            }
            else if (!stack.isEmpty()){
                char charPop=stack.pop();
                if (charStr-charPop<=2&&charStr-charPop>0)continue;
                else return false;
            }
            else return false;
        }
        if (!stack.empty())return false;
        return true;
    }
}
