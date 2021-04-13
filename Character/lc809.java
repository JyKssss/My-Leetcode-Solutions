package Character;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class lc809 {
    public int expressiveWords(String S, String[] words) {
        List<Pair<Character,Integer>>sCharCount=countCharacter(S);
        int res=0;
        for (String word : words) {
            if (word.length()>S.length()){
                continue;
            }
            if (verify(sCharCount, countCharacter(word))){
                res++;
            }
        }
        return res;
    }

    private List<Pair<Character,Integer>> countCharacter(String s){
        List<Pair<Character,Integer>>sCharCount=new ArrayList<>();
        if (s.length()==0){
            return sCharCount;
        }
        int cnt=0;
        char prev=s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==prev){
                cnt++;
            }
            else {
                sCharCount.add(new Pair<>(prev, cnt));
                prev=s.charAt(i);
                cnt=1;
            }
        }
        sCharCount.add(new Pair<>(prev, cnt));
        return sCharCount;
    }

    private boolean verify(List<Pair<Character,Integer>>SList, List<Pair<Character,Integer>>wordList){
        if (SList.size()!=wordList.size()){
            return false;
        }
        for (int i = 0; i < wordList.size(); i++) {
            Pair<Character,Integer>sPair=SList.get(i);
            Pair<Character,Integer>wordPair=wordList.get(i);
            if (sPair.getKey().equals(wordPair.getKey())){
                if (sPair.getValue().equals(wordPair.getValue())){
                    continue;
                }
                else if (sPair.getValue()>=3&&wordPair.getValue()<sPair.getValue()){
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S="heeellooo";
        String[] wordList=new String[]{"hello", "hi", "helo"};
        lc809 obj=new lc809();
        System.out.println(obj.expressiveWords(S, wordList));
    }
}
