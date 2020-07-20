package Graph;

import java.util.ArrayList;
import java.util.List;

public class lc785 {

    public boolean isBipartite(int[][] graph) {
        List<node>nodeList=new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodeList.add(new node(i));
        }
        boolean flag=true;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).color==0){
                if(!color(nodeList, graph, nodeList.get(i), 1))flag=false;
            }
        }
        return flag;
    }

    public boolean color(List<node>nodes,int[][] graph,node node,int color){
        if (node.color==0){
            node.color=color;
        }
        else if (node.color!=color){
            return false;
        }
        else if (node.color==color)return true;
        for (int i = 0; i < graph[node.id].length; i++) {
            if(!color(nodes,graph,nodes.get(graph[node.id][i]), -color)) return false;
        }
        return true;
    }
    private class node{
        int color;
        int id;

        public node(int id) {
            this.color = 0;
            this.id = id;
        }
    }
}
