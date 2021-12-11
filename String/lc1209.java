package String;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc1209 {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new LinkedList<>();
        stack.addLast(new Pair<>(s.charAt(0), 1));
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (stack.size() > 0 && stack.peekLast().getKey().equals(curChar)) {
                stack.addLast(new Pair<>(curChar, stack.peekLast().getValue() + 1));
                if (stack.peekLast().getValue() == k) {
                    for (int j = 0; j < k; j++) {
                        stack.removeLast();
                    }
                }
            } else {
                stack.addLast(new Pair<>(curChar, 1));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollFirst().getKey());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        lc1209 obj = new lc1209();
        System.out.println(obj.removeDuplicates("abcd", 2));
    }
}
