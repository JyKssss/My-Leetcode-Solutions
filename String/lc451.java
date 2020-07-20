package String;

import javafx.util.Pair;

import java.util.*;

public class lc451 {
    /**
     * 用数组加上StringBuilder最快
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        int[] charNum=new int[128];
        char[] chars=s.toCharArray();
        List<Pair<Character,Integer>>sortedList=new ArrayList<>();
        for (char single:chars){
            charNum[(int)single]=charNum[(int)single]+1;
//            System.out.println((int)single);
        }
        for (int i = 0; i < charNum.length; i++) {
            if (charNum[i]>0){
                Pair<Character,Integer>singleChar=new Pair<>((char)i,charNum[i]);
                sortedList.add(singleChar);
                System.out.println(singleChar.getKey());
            }
        }
        Collections.sort(sortedList, new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        StringBuilder stringBuilder=new StringBuilder();
        for(Pair<Character,Integer>pair:sortedList){
            for (int i = 0; i < pair.getValue(); i++) {
                stringBuilder.append(pair.getKey());
            }
        }
        return stringBuilder.toString();
//        String res="";
//        for(Pair<Character,Integer>set:sortedList){
//            for (int i = 0; i < set.getValue(); i++) {
//                res=res+set.getKey();
//            }
//        }
//        return res;
    }

    /**
     * 字符串拼接用StringBuilder 但hashmap稍慢了
     * @param s
     * @return
     */
    public String frequencySort2(String s) {
        if (s.length()==0)return s;
        HashMap<Character,Integer>freq=new HashMap<>();
        List<Pair<Character,Integer>>sortedList=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (freq.containsKey(s.charAt(i))){
                freq.replace(s.charAt(i), freq.get(s.charAt(i))+1);
            }
            else freq.put(s.charAt(i), 1);
        }
        for(Character character:freq.keySet()){
            sortedList.add(new Pair<>(character, freq.get(character)));
        }
        Collections.sort(sortedList, new Comparator<Pair<Character, Integer>>() {
            @Override
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        for(Pair<Character,Integer>pair:sortedList){
            for (int i = 0; i < pair.getValue(); i++) {
                stringBuilder.append(pair.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
