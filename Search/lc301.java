package Search;

import java.util.*;

public class lc301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> validList = new ArrayList<>();
        Deque<String> genList = new LinkedList<>();
        HashSet<String> stringSet = new HashSet<>(), validSet = new HashSet<>();
        boolean isValid = false;
        if (checkValid(s)){
            validList.add(s);
            return validList;
        }
        genList.addLast(s);
        while (!isValid){
            int size = genList.size();
            for (int i = 0; i < size; i++) {
                String curString = genList.pollFirst();
                for (int j = 0; j < curString.length(); j++) {
                    if (curString.charAt(j) == '(' || curString.charAt(j) == ')'){
                        String subString = curString.substring(0, j);
                        if (j + 1 < curString.length()){
                            subString += curString.substring(j+1);
                        }
                        if (!stringSet.contains(subString)){
                            stringSet.add(subString);
                            genList.addLast(subString);
                        }

                        if (checkValid(subString)){
                            isValid = true;
                            if (!validSet.contains(subString)){
                                validSet.add(subString);
                                validList.add(subString);
                            }
                        }
                    }
                }
            }
        }
        return validList;
    }

    private boolean checkValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                cnt++;
            }
            else if (s.charAt(i)==')'){
                cnt--;
            }
            if (cnt < 0){
                return false;
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        lc301 obj = new lc301();
        String s = "()())()";
        System.out.println(obj.removeInvalidParentheses(s).toString());
    }
}
