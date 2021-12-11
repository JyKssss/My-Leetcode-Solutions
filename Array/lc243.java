package Array;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class lc243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> word1list = new ArrayList<>();
        TreeSet<Integer> word2set = new TreeSet<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                word1list.add(i);
            } else if (wordsDict[i].equals(word2)) {
                word2set.add(i);
            }
        }
        int minDis = wordsDict.length;
        for (Integer index1 : word1list) {
            Integer ceil = word2set.ceiling(index1);
            Integer floor = word2set.floor(index1);
            if (ceil != null) {
                minDis = Math.min(minDis, ceil - index1);
            }
            if (floor != null) {
                minDis = Math.min(minDis, index1 - floor);
            }
        }
        return minDis;
    }
}
