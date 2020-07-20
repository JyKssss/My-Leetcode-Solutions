package String;

import java.util.Stack;

public class lc151 {
    /**
     * 用split分开各个单词 用栈反转
     * 注意String判断空需要用 length==0来判断
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String res=new String();
        s=s.trim();
        if (s.length()==0)return res;
        if (s.length()==1)return s;
        String[] words=s.split(" ");
        Stack<String>stringStack=new Stack<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length()==0)continue;
            stringStack.push(words[i].trim());
        }
        StringBuffer stringBuffer=new StringBuffer();
        int size=stringStack.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(stringStack.pop());
            if (i<size-1){
                stringBuffer.append(" ");
            }
        }
        res=stringBuffer.toString();
//        res.trim();
//        if (res.charAt(res.length()-1)==' ')return res.substring(0, res.length()-1);
        return res;
    }

}
