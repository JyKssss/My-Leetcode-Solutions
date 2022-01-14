package Recursion;

import java.util.ArrayList;
import java.util.List;

public class lc22 {
    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        List<String> result = new ArrayList<>();
        recurse(new StringBuilder(), left, right, result);
        return result;
    }

    private void recurse(StringBuilder stringBuilder, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        if (left < right) {
            if (left > 0) {
                stringBuilder.append('(');
                recurse(stringBuilder, left - 1, right, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (right > 0) {
                stringBuilder.append(')');
                recurse(stringBuilder, left, right - 1, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        } else {
            if (left > 0) {
                stringBuilder.append('(');
                recurse(stringBuilder, left - 1, right, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        lc22 obj = new lc22();
        System.out.println(obj.generateParenthesis(3));
    }
}
