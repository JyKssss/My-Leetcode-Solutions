package String;

import java.util.Deque;
import java.util.LinkedList;

public class lc71 {
    /**
     * 可以存在"..." 不能存在"." ".."
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        StringBuffer stringBuffer=new StringBuffer();
        Deque<Character>stack=new LinkedList<>();
        stack.addLast('/');
        path=path.concat("/");
        int index=0;
        while (index<path.length()){
            char cur=path.charAt(index);
            if (cur=='.'){
                stack.addLast(cur);
            }
            else {
                if (cur=='/'){
                    int cnt=0;
                    while (!stack.isEmpty()&&stack.peekLast()=='.'){
                        cnt++;
                        stack.pollLast();
                    }
                    if (cnt>2||(!stack.isEmpty()&&stack.peekLast()!='/')){
                        for (int i = 0; i < cnt; i++) {
                            stack.addLast('.');
                        }
                    }
                    else if (cnt==2){
                        int cnt2=0;
                        while (cnt2<2&&stack.size()>0){
                            char c=stack.pollLast();
                            if (c=='/')cnt2++;
                        }
                        stack.addLast('/');
                    }

                    if (stack.isEmpty()||stack.peekLast()!='/'){
                        stack.addLast('/');
                    }
                }
                else {
                    stack.addLast(cur);
                }
            }
            index++;
        }
        if (stack.size()>1&&stack.peekLast()=='/'){
            stack.pollLast();
        }

        while (stack.size()>0){
            stringBuffer.append(stack.pollFirst());
        }
        return stringBuffer.toString();
    }
}
