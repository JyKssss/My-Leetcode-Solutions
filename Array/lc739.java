package Array;

import java.util.Stack;

public class lc739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        Stack<Temp>stack=new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.size()==0||stack.peek().temperature>=T[i]){
                stack.push(new Temp(i, T[i]));
            }
            else {
                while (stack.size()>0&&stack.peek().temperature<T[i]){
                    Temp tmp=stack.pop();
                    res[tmp.date]=i-tmp.date;
                }
                stack.push(new Temp(i, T[i]));
            }
        }
        while (stack.size()>0){
            Temp tmp=stack.pop();
            res[tmp.date]=0;
        }
        return res;
    }

    private class Temp {
        int date;
        int temperature;

        public Temp(int date, int temperature) {
            this.date = date;
            this.temperature = temperature;
        }
    }
}
