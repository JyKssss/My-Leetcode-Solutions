package String;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class lc647 {
    public int countSubstrings(String s) {
        if (s.length()==0||s.length()==1)return s.length();
        char[] chars=s.toCharArray();
        int res=0;
        List<Pair<Integer,Integer>>oddReverse=new ArrayList<>();
        List<Pair<Integer,Integer>>evenReverse=new ArrayList<>();
        List<Pair<Integer,Integer>>intermediate=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            oddReverse.add(new Pair<>(i, i));
            res++;
            if (i<chars.length-1&&chars[i]==chars[i+1]){
                evenReverse.add(new Pair<>(i, i+1));
                res++;
            }
        }
        int length=3;
        while (length<=s.length()){
            if (oddReverse.size()==0&&evenReverse.size()==0)break;
            if (length%2==1){
                for (int i = 0; i < oddReverse.size(); i++) {
                    int start=oddReverse.get(i).getKey();
                    int end=oddReverse.get(i).getValue();
                    if (start>0&&end<s.length()-1){
                        if (chars[start-1]==chars[end+1]){
                            intermediate.add(new Pair<>(start-1, end+1));
                            res++;
                        }
                    }
                    else continue;
                }
                length++;
                if (intermediate.size()>0){
                    oddReverse=intermediate;
                    intermediate=new ArrayList<>();
                }
                else {
                    oddReverse.clear();
                    intermediate.clear();
                }
            }
            else {
                for (int i = 0; i < evenReverse.size(); i++) {
                    int start=evenReverse.get(i).getKey();
                    int end=evenReverse.get(i).getValue();
                    if (start>0&&end<s.length()-1){
                        if (chars[start-1]==chars[end+1]){
                            intermediate.add(new Pair<>(start-1, end+1));
                            res++;
                        }
                    }
                    else continue;
                }
                length++;
                if (intermediate.size()>0){
                    evenReverse=intermediate;
                    intermediate=new ArrayList<>();
                }
                else {
                    evenReverse.clear();
                    intermediate.clear();
                }
            }
        }
        return res;
    }
}
