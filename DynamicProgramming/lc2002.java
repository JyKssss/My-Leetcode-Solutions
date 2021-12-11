package DynamicProgramming;

import java.util.HashMap;

public class lc2002 {
    int max = 0;
    HashMap<String, Integer> map;
    public int maxProduct(String s) {
        productHelper(s, new StringBuffer(), new StringBuffer(), 0);
        return max;
    }

    private void productHelper(String s, StringBuffer s1, StringBuffer s2, int index) {
        if (isPalindromic(s1) && isPalindromic(s2)){
            max = Math.max(max, s1.length() * s2.length());
        }
        if (index == s.length()){
            return;
        }
        productHelper(s, s1.append(s.charAt(index)), s2, index + 1);
        s1.deleteCharAt(s1.length() - 1);
        productHelper(s, s1, s2.append(s.charAt(index)), index + 1);
        s2.deleteCharAt(s2.length() - 1);
        productHelper(s, s1, s2, index + 1);

    }

    private boolean isPalindromic (StringBuffer sb){
        int start = 0, end = sb.length() -1;
        while (start < end){
            if (sb.charAt(start) != sb.charAt(end)){
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
}
