package Array;

import java.util.*;

public class lc1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>>pairMap=new HashMap<>();
        HashSet<Integer>visitedSet=new HashSet<>();
        for (int[] pair : adjacentPairs) {
            List<Integer>list=pairMap.getOrDefault(pair[0],new ArrayList<>());
            list.add(pair[1]);
            pairMap.put(pair[0], list);
            list=pairMap.getOrDefault(pair[1],new ArrayList<>());
            list.add(pair[0]);
            pairMap.put(pair[1], list);
        }
        int cur=0;
        int[]res=new int[adjacentPairs.length+1];
        for (Map.Entry<Integer, List<Integer>> entry : pairMap.entrySet()) {
            if (entry.getValue().size()==1){
                cur=entry.getKey();
                res[0]=cur;
                visitedSet.add(cur);
                break;
            }
        }
        for (int i = 1; i < res.length ; i++) {
            List<Integer>linkList=pairMap.get(cur);
            for (Integer link : linkList) {
                if (!visitedSet.contains(link)){
                    res[i]=link;
                    cur=link;
                    visitedSet.add(cur);
                    break;
                }
            }
        }
        return res;
    }
}
