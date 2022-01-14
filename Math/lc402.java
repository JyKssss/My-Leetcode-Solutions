package Math;

import java.util.Stack;

public class lc402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            if (stack.size() == 0 || stack.peek() <= cur) {
                stack.push(cur);
            } else {
                while (stack.size() > 0 && stack.peek() > cur && k > 0) {
                    stack.pop();
                    k -= 1;
                }
                stack.push(cur);
            }
        }
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() > 0) {
            stringBuilder.insert(0, stack.pop());
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.delete(0, 1);
        }
        return stringBuilder.toString();
    }
}
