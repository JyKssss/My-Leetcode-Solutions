package String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class lc316 {
    /**
     * 用hash表储存每个元素的数量和入栈与否
     * 循环入栈 如果大于栈顶元素则正常入栈 小于栈顶元素 判断后续是否还存在栈顶元素 如无只能入栈 如有则可以pop栈顶元素 接着判断新的栈顶元素
     * 直到栈顶元素小于当前元素后入栈 一直循环
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Boolean>inStack=new HashMap<>();
        HashMap<Character,Integer>charNum=new HashMap<>();
        Deque<Character>deque=new LinkedList<>();
        char[] chars=s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (!inStack.containsKey(cur))inStack.put(cur, false);
            if (!charNum.containsKey(cur))charNum.put(cur, 1);
            else charNum.replace(cur, charNum.get(cur)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (deque.isEmpty()){
                deque.addLast(chars[i]);
                System.out.println("empty "+chars[i]);
                inStack.replace(chars[i],true);
                charNum.replace(chars[i],charNum.get(chars[i])-1);
            }
            else {
                if (chars[i]>deque.peekLast()&&inStack.get(chars[i])==false){
                    deque.addLast(chars[i]);
                    inStack.replace(chars[i],true);
                    charNum.replace(chars[i],charNum.get(chars[i])-1);
                    System.out.println("normal "+chars[i]);
                }
                else if (inStack.get(chars[i])==true){
                    charNum.replace(chars[i],charNum.get(chars[i])-1);
                    System.out.println("skip "+chars[i]);
                    continue;
                }
                else if (chars[i]<deque.peekLast()&&inStack.get(chars[i])==false){
                    while (!deque.isEmpty()&&deque.peekLast()>chars[i]){
                        char tmp=deque.peekLast();
                        System.out.println("tmp "+deque.peekLast());
                        if (charNum.get(tmp)==0){
                            deque.addLast(chars[i]);
                            inStack.replace(chars[i],true);
                            charNum.replace(chars[i],charNum.get(chars[i])-1);
                            System.out.println("<1 "+chars[i]);
                            break;
                        }
                        else {
                            char pop= deque.pollLast();
                            System.out.println("pop "+pop);
                            System.out.println("pop size"+charNum.get(pop));
                            inStack.replace(pop, false);
                            if (deque.isEmpty()||deque.peekLast()<chars[i]){
                                deque.addLast(chars[i]);
                                inStack.replace(chars[i],true);
                                charNum.replace(chars[i],charNum.get(chars[i])-1);
                                System.out.println("emptypopadd "+chars[i]);
                                break;
                            }
                        }
                    }
                }
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (!deque.isEmpty()){
            stringBuffer.append(deque.pollFirst());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String str="dbede";
        lc316 l=new lc316();
        System.out.println(l.removeDuplicateLetters(str));
    }
}
