package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer>repeatIndex=new ArrayList<>();
        HashSet<String>wordSet=new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            wordSet.add(wordDict.get(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i+1))){
                repeatIndex.add(i);
                continue;
            }
            else {
                for (int j = repeatIndex.size()-1; j >=0; j--) {
                    if (wordDict.contains(s.substring(repeatIndex.get(j)+1, i+1))){
                        repeatIndex.add(i);
                        break;
                    }
                }
            }
        }
        if (repeatIndex.size()==0)return false;
        else return repeatIndex.get(repeatIndex.size()-1).equals(s.length()-1);
    }
}
