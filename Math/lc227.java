package Math;

import java.util.Deque;
import java.util.LinkedList;

public class lc227 {
    public int calculate(String s) {
        Deque<Integer>stack=new LinkedList<>();
        int index=0,  num=0;
        char pivot='+';
        while (index<s.length()){
            char c=s.charAt(index);
            if (Character.isDigit(c)){
                num=10*num+(c-'0');
            }
            if ((!Character.isDigit(c)&& c!=' ')||index==s.length()-1){
                if (pivot=='+'||pivot=='-'){
                    num=pivot=='+'?num:-num;
                    stack.addLast(num);
                }
                else if (pivot=='*'){
                    int pre=stack.pollLast();
                    stack.addLast(pre*num);
                }
                else if (pivot=='/'){
                    int pre=stack.pollLast();
                    stack.addLast(pre/num);
                }
                num=0;
                pivot=c;
            }
            index++;
        }
        int sum=0;
        while (!stack.isEmpty()){
            sum+=stack.pollFirst();
        }
        return sum;
    }

    public static void main(String[] args) {
        lc227 obj=new lc227();
        String s="42";
        System.out.println(obj.calculate(s));
    }
}
