package String;

import java.util.Deque;
import java.util.LinkedList;

public class lc1047 {
    public String removeDuplicates(String S) {
        Deque<Character>deque=new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (deque.isEmpty() || deque.peekLast()!=S.charAt(i)){
                deque.addLast(S.charAt(i));
            }
            else {
                deque.removeLast();
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (!deque.isEmpty()){
            stringBuffer.append(deque.pollFirst());
        }
        return stringBuffer.toString();
    }
}
