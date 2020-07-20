package String;

import java.util.Stack;

public class lc557 {
    public String reverseWords(String s) {
        s=s.trim();
        if (s.length()==0||s.length()==1)return s;
        String[] splitStrs=s.split(" ");
        Stack<Character> stack=new Stack<>();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < splitStrs.length; i++) {
            for (int j = 0; j < splitStrs[i].length(); j++) {
                stack.push(splitStrs[i].charAt(j));
            }
            StringBuffer word=new StringBuffer();
            while (!stack.isEmpty()){
                word.append(stack.pop());
            }
            stringBuffer.append(word.toString());
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        lc557 l=new lc557();
        System.out.println(l.reverseWords("Let's take LeetCode contest"));
    }
}
