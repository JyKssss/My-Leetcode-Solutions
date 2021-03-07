package String;

import java.util.*;

public class lc140 {
    /**
     * 回溯加记忆化递归
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet=new HashSet<>();
        for(String word:wordDict){
            wordSet.add(word);
        }
        List<List<String>> resList=new ArrayList<>();
        List<String>solu=new ArrayList<>();
        wordBreakHelper(s, resList, solu, wordSet, 0, s.length());
        List<String>res=new ArrayList<>();
        for(List<String>solution:resList){
            StringBuffer stringBuffer=new StringBuffer();
            for (int i = 0; i < solution.size(); i++) {
                stringBuffer.append(solution.get(i));
                if (i<solution.size()-1){
                    stringBuffer.append(" ");
                }
            }
            res.add(stringBuffer.toString());
        }

        return res;
    }

    public void wordBreakHelper(String s, List<List<String>> resList, List<String>solution,HashSet<String> wordSet, int start ,int end){
        if (start==end){
            resList.add(new ArrayList<>(solution));
            return;
        }
        for (int i = start; i <end ; i++) {
            if (wordSet.contains(s.substring(start,i+1))){
                solution.add(s.substring(start, i+1));
                wordBreakHelper(s, resList, solution, wordSet, i+1, end);
                solution.remove(solution.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        lc140 obj=new lc140();
        String s="pineapplepenapple";
        List<String>list =new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String>res=obj.wordBreak(s, list);
        for(String str: res){
            System.out.println(str);
        }
    }
}
