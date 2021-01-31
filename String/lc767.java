package String;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class lc767 {
    public String reorganizeString(String S) {
        int max=0;
        int[] characterCount=new int[26];
        for (int i = 0; i < S.length(); i++) {
            characterCount[S.charAt(i)-'a']++;
            max=characterCount[S.charAt(i)-'a']>max?characterCount[S.charAt(i)-'a']:max;
        }
        if (max>(S.length()+1)/2)return "";
        PriorityQueue<Pair<Character,Integer>>heap=new PriorityQueue<>(new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                int r=o2.getValue()-o1.getValue();
                if (r!=0)return r;
                else return o2.getKey()-o1.getKey();
            }
        });
        for (int i = 0; i < characterCount.length; i++) {
            if (characterCount[i]==0)continue;
            else {
                heap.offer(new Pair<>((char) ('a'+i), characterCount[i]));
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (heap.size()>0){
            Pair<Character,Integer>wordPair1=heap.poll();
            stringBuffer.append(wordPair1.getKey());
            System.out.println(wordPair1.getKey());
            if (heap.size()>0){
                Pair<Character,Integer>wordPair2=heap.poll();
                stringBuffer.append(wordPair2.getKey());
                System.out.println(wordPair2.getKey());
                if (wordPair2.getValue()>1)heap.offer(new Pair<>(wordPair2.getKey(),wordPair2.getValue()-1));
            }
            if (wordPair1.getValue()>1)heap.offer(new Pair<>(wordPair1.getKey(),wordPair1.getValue()-1));
        }
        return stringBuffer.toString();
    }
}
