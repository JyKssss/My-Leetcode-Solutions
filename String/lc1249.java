package String;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
//        Deque<Integer> rightStack = new LinkedList<>();
        HashSet<Integer> toDelSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftStack.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (leftStack.size() > 0) {
                    leftStack.removeLast();
                } else {
                    toDelSet.add(i);
                }
            }
        }
        while (leftStack.size() != 0) {
            toDelSet.add(leftStack.pollLast());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!toDelSet.contains(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
