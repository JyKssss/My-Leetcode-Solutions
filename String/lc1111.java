package String;

import java.util.LinkedList;
import java.util.Stack;

public class lc1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char cur = seq.charAt(i);
            if (cur == '(') {
                depth += 1;
                res[i] = depth % 2;
            } else if (cur == ')') {
                res[i] = depth % 2;
                depth -= 1;
            }
        }
        return res;
    }
}
