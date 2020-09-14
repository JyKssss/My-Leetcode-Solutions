package Array;

import java.util.HashMap;

public class lc1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //亲近程度矩阵
        int[][] closeMatrix=new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                closeMatrix[i][preferences[i][j]]=j;
            }
        }
        HashMap<Integer,Integer>pairMaps=new HashMap<>();
        for (int[] pair: pairs) {
            pairMaps.put(pair[0],pair[1]);
            pairMaps.put(pair[1],pair[0]);
        }
        int unhappyCount=0;
        for(Integer p: pairMaps.keySet()){
            int q=pairMaps.get(p);
            int closeRate=closeMatrix[p][q];
            for (int i = 0; i < closeRate; i++) {
                int closer=preferences[p][i];
                int closerPair=pairMaps.get(closer);
                if (closeMatrix[closer][closerPair]>closeMatrix[closer][p]){
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}
