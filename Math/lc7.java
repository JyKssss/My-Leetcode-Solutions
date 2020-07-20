package Math;

import java.util.Stack;

public class lc7 {
    public int reverse(int x) {
        if (x==0)return 0;
        String str=String.valueOf(x);
        Stack<Character>numStack=new Stack<>();
        StringBuffer stringBuffer=new StringBuffer();
        boolean isNegative=false;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)=='-'){
                isNegative=true;
                continue;
            }
            numStack.push(str.charAt(i));
        }
        int length=numStack.size();
        for (int i = 0; i < length; i++) {
            if (stringBuffer.length()==0&&numStack.peek()=='0'){
                numStack.pop();
                continue;
            }
            else stringBuffer.append(numStack.pop());
        }
        if (isNegative){
            long verify=-Long.valueOf(stringBuffer.toString());
            if (verify<Integer.MIN_VALUE)return 0;
            else {
                return -Integer.valueOf(stringBuffer.toString());
            }

        }
        else {
            long verify=Long.valueOf(stringBuffer.toString());
            if (verify>Integer.MAX_VALUE)return 0;
            else {
                return Integer.valueOf(stringBuffer.toString());
            }
        }
    }
}
