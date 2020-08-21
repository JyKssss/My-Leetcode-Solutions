package Search;

import java.util.*;

public class lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int minLen=Integer.MAX_VALUE;
        HashMap<String,List<String>>wordsMap=new HashMap<>();
        for(String word: wordList)wordsMap.put(word, new ArrayList<>());
        if (!wordsMap.containsKey(endWord))return 0;
        wordsMap.put(beginWord, new ArrayList<>());
        for(Map.Entry<String, List<String>>entry: wordsMap.entrySet()){
            if (entry.getKey().equals(endWord))continue;
            String word=entry.getKey();
            System.out.println("origin :"+word);
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char[] chars=word.toCharArray();
                    chars[i]= (char) ('a'+j);
                    String newWord=new String(chars);
//                    System.out.println(newWord);
                    if (!newWord.equals(word)&&!newWord.equals(beginWord)&&wordsMap.containsKey(newWord)){
                        wordsMap.get(word).add(newWord);
                    }
                }
            }
        }
        int length=1;
        Deque<String>wordsLayer=new LinkedList<>(wordsMap.get(beginWord));
        HashSet<String>visited=new HashSet<>(wordsMap.get(beginWord));
        length++;
        while (!wordsLayer.isEmpty()){
            int size=wordsLayer.size();
            for (int i = 0; i < size; i++) {
                String word=wordsLayer.pollFirst();
                if (word.equals(endWord))return length;
                else {
                    for(String next:wordsMap.get(word)){
                        if (!visited.contains(next)){
                            wordsLayer.addLast(next);
                            visited.add(next);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}
