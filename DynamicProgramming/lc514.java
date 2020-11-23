package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lc514 {
    public int findRotateSteps(String ring, String key) {
        //维护一个各个key的位置的hashmap
        HashMap<Character, List<Integer>>keyIndexMap=new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            if (keyIndexMap.containsKey(ring.charAt(i)))keyIndexMap.get(ring.charAt(i)).add(i);
            else{
                keyIndexMap.put(ring.charAt(i), new ArrayList<>());
                keyIndexMap.get(ring.charAt(i)).add(i);
            }
        }
        int[][] dp=new int[key.length()][ring.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int len=ring.length();
        for (int i = 0; i < key.length(); i++) {
            List<Integer>indexs=keyIndexMap.get(key.charAt(i));
            List<Integer>preIndexs=i>0?keyIndexMap.get(key.charAt(i-1)):null;
            for(Integer index:indexs){
                if (i==0){
                    dp[i][index]=Math.min(index, len-index)+1;
                }
                else {
                    dp[i][index]=Integer.MAX_VALUE;
                    for(Integer preIndex:preIndexs){
                        dp[i][index]=Math.min(dp[i][index],Math.min(Math.abs(index-preIndex), len-Math.abs(preIndex-index))+dp[i-1][preIndex]+1);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        List<Integer>endIndexs=keyIndexMap.get(key.charAt(key.length()-1));
        for(Integer endIndex:endIndexs){
            min=Math.min(min, dp[key.length()-1][endIndex]);
        }
        return min;
    }
}
