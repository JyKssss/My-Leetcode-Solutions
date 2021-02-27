package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer,Integer>wordsMap=new HashMap<>();
        for(String word:words){
            int bitWord=0;
            for (int i = 0; i < word.length(); i++) {
                bitWord |=(1<<(word.charAt(i)-'a'));
            }
            if (wordsMap.containsKey(bitWord)){
                wordsMap.put(bitWord, wordsMap.get(bitWord)+1);
            }
            else {
                wordsMap.put(bitWord, 1);
            }
        }

        List<Integer>res=new ArrayList<>();
        for(String puzzle:puzzles){
            int count=0;
            List<Integer>subsetList=subsetGenerate(puzzle);
            for (Integer sub:subsetList){
                count+=wordsMap.getOrDefault(sub, 0);
            }
            res.add(count);
        }
        return res;
    }

    List<Integer> subsetGenerate(String puzzle){
        List<Integer>subList=new ArrayList<>();
        int bitMask=(1<<(puzzle.charAt(0)-'a'));
        helper(subList, 1, bitMask, puzzle);
        return subList;
    }

    void helper(List<Integer>subList,int index,int bitMask,String puzzle){
        if (index==7){
            subList.add(bitMask);
            return;
        }
        helper(subList, index+1, bitMask, puzzle);
        bitMask |=(1<<(puzzle.charAt(index)-'a'));
        helper(subList, index+1, bitMask, puzzle);
    }
}
