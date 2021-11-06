package Contest;

import java.util.Arrays;

public class didi {
    String arrangement;
    Boolean isFind;
    public String solution(String S) {
        // write your code in Java SE 8
        char[] chars = S.toCharArray();
        arrangement = null;
        isFind = false;
        dfs(chars, 0);
        return arrangement;
    }

    private void dfs(char[] S, int index){
        if (isFind == true){
            return;
        }
        while (index < S.length && S[index] != '?' ){
            index++;
        }
        if (index == S.length){
            arrangement = String.copyValueOf(S);
            isFind = true;
            return;
        }
        if (helper(S, index, 'a')){
            S[index] = 'a';
            dfs(S, index + 1);
            S[index] = '?';
        }
        else if (helper(S, index, 'b')){
            S[index] = 'b';
            dfs(S, index + 1);
            S[index] = '?';
        }
        else {
            return;
        }

    }

    private boolean helper(char[] S, int index, char type){
        S[index] = type;
        int start = Math.max(0, index - 2);
        int end = Math.min(S.length - 1, index + 2);
        while (start + 2 <= end){
            boolean isIn = false;
            for (int i = start; i <= start + 2 ; i++) {
                if (S[i] != type){
                    isIn = true;
                }
            }
            if (isIn == false){
                S[index] ='?';
                return false;
            }
            start += 1;
        }
        S[index] ='?';
        return true;
    }

    public static void main(String[] args) {
        didi obj = new didi();
        String s = "??abb";
        System.out.println(obj.solution(s));
    }
}
