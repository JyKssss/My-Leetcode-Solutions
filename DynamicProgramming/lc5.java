package DynamicProgramming;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 状态转移方程 P(i,j)=P(i+1,j-1)+(?i==j) 先找出长度1 2 的回文子串
 */
public class lc5 {
    public static void main(String[] args) {
        String str="cbbd";
        String res=longestPalindrome(str);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        char[] schar=s.toCharArray();
        if (schar.length==0)return "";
        List<Pair<Integer,Integer>>oddPair=new ArrayList<>();
        List<Pair<Integer,Integer>>evenPair=new ArrayList<>();
        List<Pair<Integer,Integer>>interPair=new ArrayList<>();
        List<Pair<Integer,Integer>>resultPair=new ArrayList<>();
        for (int i = 0; i < schar.length; i++) {
            Pair<Integer,Integer> odd=new Pair<>(i, i);
            oddPair.add(odd);
            if (i<schar.length-1 && schar[i]==schar[i+1]){
                Pair<Integer,Integer> even=new Pair<>(i, i+1);
                evenPair.add(even);
            }
        }
        int length=3;
        while (length<=schar.length){
            System.out.println(oddPair.size()+" "+evenPair.size());
            if (length%2==1){
                for(Pair<Integer,Integer> odd:oddPair){
                    int start=odd.getKey();
                    int end=odd.getValue();
                    if (start>0&&end<schar.length-1&&schar[start-1]==schar[end+1]){
                        interPair.add(new Pair<>(start-1, end+1));
                    }
                }
                if (interPair.size()==0){
                    length++;
                    continue;
                }
                length++;
                oddPair.clear();
                oddPair.addAll(interPair);
                interPair.clear();
            }
            else {
                for (Pair<Integer,Integer> even:evenPair){
                    int start=even.getKey();
                    int end=even.getValue();
                    if (start>0&&end<schar.length-1&&schar[start-1]==schar[end+1]){
                        interPair.add(new Pair<>(start-1, end+1));
                    }
                }
                if (interPair.size()==0){
                    length++;
                    continue;
                }
                length++;
                evenPair.clear();
                evenPair.addAll(interPair);
                interPair.clear();
            }
        }
        char[] result;
        if (oddPair.size()>0&&evenPair.size()>0){
            Pair<Integer,Integer> resOdd=oddPair.get(0);
            Pair<Integer,Integer> resEven=evenPair.get(0);
            int startO=resOdd.getKey();
            int endO=resOdd.getValue();
            int startE=resEven.getKey();
            int endE=resEven.getValue();

            if (endO-startO>endE-startE){
                result=Arrays.copyOfRange(schar, startO, endO+1);
            }
            else {
                result=Arrays.copyOfRange(schar, startE, endE+1);
            }
        }
        else if (oddPair.size()>0&&evenPair.size()==0){
            Pair<Integer,Integer> resOdd=oddPair.get(0);
            int startO=resOdd.getKey();
            int endO=resOdd.getValue();
            result=Arrays.copyOfRange(schar, startO, endO+1);
        }
        else {
            Pair<Integer,Integer> resEven=evenPair.get(0);
            int startE=resEven.getKey();
            int endE=resEven.getValue();
            result=Arrays.copyOfRange(schar, startE, endE+1);
        }
        StringBuffer res=new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            res.append(result[i]);
        }
        return res.toString();
    }
}
