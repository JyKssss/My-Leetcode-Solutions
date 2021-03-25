package Math;

import java.util.Deque;
import java.util.LinkedList;

public class lc224 {
    public int calculate(String s){
        LinkedList<Character>characterLinkedList= new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            characterLinkedList.addLast(s.charAt(i));
        }
        return calculateHelper(characterLinkedList);
    }

    public int calculateHelper(LinkedList<Character> list) {
        int num=0, pivot=1;
        Deque<Integer>stack=new LinkedList<>();
        while (list.size()>0){
            Character c=list.pollFirst();
            if (Character.isDigit(c)){
                num=10*num+Integer.valueOf(c-'0');
            }
            else if (c=='+'||c=='-'){
                stack.addLast(pivot*num);
                pivot=c=='+'?1:-1;
                num=0;
            }
            else if (c=='('){
                num=calculateHelper(list);
            }
            else if (c==')'){
                stack.addLast(pivot*num);
                break;
            }

            if (list.size()==0){
                stack.addLast(pivot*num);
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.poll();
        }
        return res;
    }


    public int calculate2(String s){
        int sum=0,num=0,pivot=1,index=0;
        while (index<s.length()){
            if (Character.isDigit(s.charAt(index))){
                num=10*num+(s.charAt(index)-'0');
            }
            else if (s.charAt(index)=='+'||s.charAt(index)=='-'){
                sum+=pivot*num;
                num=0;
                pivot=s.charAt(index)=='+'?1:-1;
            }
            index++;
        }
        sum+=num*pivot;
        return sum;
    }

    public static void main(String[] args) {
        lc224 obj=new lc224();
        String s="- (3 + (4 + 5))";
        System.out.println(obj.calculate(s));
    }
}
