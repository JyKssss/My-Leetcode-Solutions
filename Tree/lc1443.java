package Tree;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.List;

public class lc1443 {
    /**
     * 从根节点到每个苹果节点的路径会走两遍 所以只用hashset保存路径最后X2
     * @param n
     * @param edges
     * @param hasApple
     * @return
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] fatherNode=new int[n];
        for (int i = 0; i < edges.length; i++) {
            int father=edges[i][0];
            int kid=edges[i][1];
            fatherNode[kid]=father;
        }
        HashSet<Pair<Integer,Integer>>visitRoute=new HashSet<>();
        int appleIndex=0;
        for (Boolean appleNode:hasApple){
            if (appleNode){
                int curIndex=appleIndex;
                while (fatherNode[curIndex]!=0){
                    visitRoute.add(new Pair<>(fatherNode[curIndex],curIndex));
                    curIndex=fatherNode[curIndex];
                }
            }
            appleIndex++;
        }
        return visitRoute.size()*2;
    }
}
