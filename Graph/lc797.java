package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc797 {
    int nodeNum;
    List<List<Integer>>routes;
    List<Integer>route;
    HashSet<Integer>isVisited;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.nodeNum= graph.length;
        this.routes=new ArrayList<>();
        this.route=new ArrayList<>();
        this.isVisited=new HashSet<>();
        dfs(graph, 0);
        return this.routes;
    }

    private void dfs(int[][] graph, int node){
        route.add(node);
        isVisited.add(node);
        if (node==nodeNum-1){
            routes.add(new ArrayList<>(route));
        }
        else {
            int[] children=graph[node];
            for (int child : children) {
                if (!isVisited.contains(child)){
                    dfs(graph, child);
                }
            }
        }
        route.remove(route.size()-1);
        isVisited.remove(node);
    }
}
