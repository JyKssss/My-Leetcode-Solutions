package Graph;

import java.util.ArrayList;
import java.util.List;

public class lc685 {
    List<node>nodes;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        setNodes(edges.length);
        int in2node=calInDegree(edges);
        if (in2node>0){
            List<int[]>edges1=new ArrayList<>();
            List<int[]>edges2=new ArrayList<>();
            List<int[]>remove=new ArrayList<>();
            int count=0;
            for (int i = edges.length-1; i >=0 ; i--) {
                if (count==0&&edges[i][1]==in2node){
                    count++;
                    remove.add(edges[i]);
                    continue;
                }
                edges1.add(edges[i]);
            }
            for (int i = 0; i < edges.length; i++) {
                if (count==1&&edges[i][1]==in2node){
                    count++;
                    remove.add(edges[i]);
                    continue;
                }
                edges2.add(edges[i]);
            }
            if (isTreeAfterRemoval(edges1))return remove.get(0);
            else return remove.get(1);
        }
        setNodes(edges.length);
        return unionFind(edges);

    }

    public void setNodes(int len){
        nodes=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            nodes.add(new node(i+1));
        }
    }

    public int calInDegree(int[][] edges){
        int[] indegrees=new int[edges.length];
        int[] edge=null;
        for(int[] e: edges){
            indegrees[e[1]-1]++;
            if (indegrees[e[1]-1]>1)return e[1];
        }
        return 0;
    }

    public boolean isTreeAfterRemoval(List<int[]> edges){
        for(int[] edge: edges){
            if(findParent(nodes.get(edge[0]-1))!=findParent(nodes.get(edge[1]-1))){
                nodes.get(edge[1]-1).parent=nodes.get(edge[0]-1).id;
            }else return false;
        }
        int p=findParent(nodes.get(0));
        for(node n:nodes){
            if (p!=findParent(n))return false;
        }
        return true;
    }

    public int[] unionFind(int[][] edges){
        for(int[]e:edges){
            node n1=nodes.get(e[0]-1);
            node n2=nodes.get(e[1]-1);
            int p1=findParent(n1),p2=findParent(n2);
            if (p1!=p2){
                nodes.get(p2-1).parent=p1;
            }
            else return e;
        }
        return null;
    }
    public int findParent(node n){
        while (n.parent!=n.id){
            n=nodes.get(n.parent-1);
        }
        return n.id;
    }

    class node{
        int id;
        int parent;

        public node(int id) {
            this.id = id;
            this.parent=id;
        }
    }
}
