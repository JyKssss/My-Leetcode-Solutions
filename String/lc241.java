package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc241 {
    /**
     * 递归求解 遇到计算符号就分开成两个子串递归求解所有可能值 最后再根据两个可能值算出该串的可能值
     * 加Hashmap提高效率
     * @param input
     * @return
     */
    HashMap<String,List<Integer>>resHash=new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length()==0)return new ArrayList<>();
        List<Integer>res=new ArrayList<>();
//        HashSet<Integer>hashSet=new HashSet<>();
        int index=0,len=input.length();
        while (index<len&&!isOperation(input.charAt(index))){
            index++;
        }
        if (len==index){
            res.add(Integer.valueOf(input));
            return res;
        }
        for (int i = 0; i < len; i++) {
            if (isOperation(input.charAt(i))){
                char op=input.charAt(i);
                String left=input.substring(0, i);
                String right=input.substring(i+1);
                List<Integer>resl=new ArrayList<>();
                List<Integer>resr=new ArrayList<>();
                if (resHash.containsKey(left)){
                    resl=resHash.get(left);
                }
                else resl=diffWaysToCompute(left);
                if (resHash.containsKey(right)){
                    resr=resHash.get(right);
                }
                else resr=diffWaysToCompute(right);
                for (int j = 0; j < resl.size(); j++) {
                    for (int k = 0; k < resr.size(); k++) {
                        int toAdd=calculate(resl.get(j), op, resr.get(k));
                        res.add(toAdd);
                    }
                }
            }
        }
        resHash.put(input, res);
        return res;
    }
    public boolean isOperation(char op){
        return op=='+'||op=='-'||op=='*';
    }
    public int calculate(int n1, char operator, int n2){
        if (operator=='+')return n1+n2;
        if (operator=='-')return n1-n2;
        if (operator=='*')return n1*n2;
        return 0;
    }
}
