package Graph;

import java.util.ArrayList;
import java.util.List;

public class lc802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited=new int[graph.length];
        List<Integer>res=new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]==0){
                dfs(graph, visited, i);
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]==2){
                res.add(i);
            }
        }
        return res;
    }

    /*
    0 未访问 1 当前访问或存在环 2已访问不存在环
     */
    private boolean dfs(int[][] graph,int[] visited,int node){
        int[] nextNodes=graph[node];
        if (visited[node]==1){
            return false;
        }
        else if (visited[node]==2){
            return true;
        }
        visited[node]=1;

        boolean isSafe=true;
        for (int nextNode : nextNodes) {
            if (!dfs(graph, visited, nextNode)){
                isSafe=false;
            }
        }
        if (isSafe){
            visited[node]=2;
        }
        return isSafe;
    }
}
