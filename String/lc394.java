package String;

import java.util.LinkedList;
import java.util.Stack;

public class lc394 {
    public String decodeString(String s) {
        Stack<Character>stack =new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=']'){
                stack.push(s.charAt(i));
            }
            else {
                String tmpS;
                StringBuffer stringBuffer1=new StringBuffer();
                while (stack.peek()!='['){
                    char tmpC=stack.pop();
                    stringBuffer1.insert(0, tmpC);
                }
                tmpS=stringBuffer1.toString();
                stack.pop();
                String numStr="";
                StringBuffer stringBuffer2=new StringBuffer();
                while (!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9'){
                    stringBuffer2.insert(0, stack.pop());
                }
                numStr=stringBuffer2.toString();
                String insert;
                StringBuffer stringBuffer3=new StringBuffer();
                for (int j = 0; j < Integer.valueOf(numStr); j++) {
                    stringBuffer3.append(tmpS);
                }
                insert=stringBuffer3.toString();
                char[] insertArray=insert.toCharArray();
                for (int j = 0; j < insertArray.length; j++) {
                    stack.push(insertArray[j]);
                }
            }
        }
        StringBuffer stringBufferRes=new StringBuffer();
        while (!stack.isEmpty()){
            stringBufferRes.insert(0, stack.pop());
        }
        return stringBufferRes.toString();
    }

    int index =0;

    public String decodeString2(String s) {
        return recurse(s);
    }

    private String recurse(String s) {
        StringBuilder tempStringBuilder = new StringBuilder();
        while (index < s.length()) {
            char cur = s.charAt(index);
            index += 1;
            if (cur >='0' && cur <= '9') {
                int multi = cur - '0';
                while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    multi = multi * 10 + (s.charAt(index) - '0');
                    index += 1;
                }
                String nestString = recurse(s);
                for (int i = 0; i < multi; i++) {
                    tempStringBuilder.append(nestString);
                }
            } else if (cur == '[') {
            } else if (cur == ']') {
                break;
            } else {
                tempStringBuilder.append(cur);
            }
        }
        return tempStringBuilder.toString();
    }

    public static void main(String[] args) {
        lc394 obj = new lc394();
        System.out.println(obj.decodeString2(
                "3[a]2[bc]"));
    }
}
