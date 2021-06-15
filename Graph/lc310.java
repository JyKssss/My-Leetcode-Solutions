package Graph;

import java.util.*;

public class lc310 {
    /**
     * 简单的BruteForce+BFS 会超时
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n<=1)return new ArrayList<>();
        HashMap<Integer,List<Integer>>nodeMap=new HashMap<>();
        HashMap<Integer,List<Integer>>heightMap=new HashMap<>();
        int edge1,edge2,minHeight=Integer.MAX_VALUE;
        for (int[] edge : edges) {
            edge1=edge[0];
            edge2=edge[1];
            if (!nodeMap.containsKey(edge1)){
                nodeMap.put(edge1, new ArrayList<>());
            }
            if(!nodeMap.containsKey(edge2)){
                nodeMap.put(edge2, new ArrayList<>());
            }
            nodeMap.get(edge1).add(edge2);
            nodeMap.get(edge2).add(edge1);
        }
        for (int i = 0; i < n; i++) {
            int curH=calHeight(i, nodeMap);
            minHeight=Math.min(minHeight, curH);
            if (!heightMap.containsKey(curH)){
                heightMap.put(curH, new ArrayList<>());
            }
            heightMap.get(curH).add(i);
        }
        return heightMap.get(minHeight);
    }

    private int calHeight(int root, HashMap<Integer,List<Integer>>nodeMap){
        int height=0,size,node;
        Deque<Integer>layer=new LinkedList<>();
        HashSet<Integer>visitSet=new HashSet<>();
        layer.add(root);
        while (layer.size()>0){
            size=layer.size();
            for (int i = 0; i < size; i++) {
                node=layer.pollFirst();
                visitSet.add(node);
                List<Integer>siblings=nodeMap.get(node);
                if (siblings==null)continue;
                for (Integer sibling : siblings) {
                    if (!visitSet.contains(sibling)){
                        layer.add(sibling);
                    }
                }
            }
            height++;
        }
        return height;
    }


    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer>res=new ArrayList<>();
        if (n<=1){
            res.add(0);
            return res;
        }
        HashMap<Integer,List<Integer>>nodeMap=new HashMap<>();
        int[] degree=new int[n];
        int edge1,edge2,size;
        for (int[] edge : edges) {
            edge1=edge[0];
            edge2=edge[1];
            degree[edge1]++;
            degree[edge2]++;
            if (!nodeMap.containsKey(edge1)){
                nodeMap.put(edge1, new ArrayList<>());
            }
            if(!nodeMap.containsKey(edge2)){
                nodeMap.put(edge2, new ArrayList<>());
            }
            nodeMap.get(edge1).add(edge2);
            nodeMap.get(edge2).add(edge1);
        }
        Deque<Integer>layer=new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i]==1){
                layer.add(i);
            }
        }

        while (!layer.isEmpty()){
            size=layer.size();
            res=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int node=layer.pollFirst();
                res.add(node);
                degree[node]--;
                List<Integer>linkedNodes=nodeMap.get(node);
                for (Integer linkedNode : linkedNodes) {
                    degree[linkedNode]--;
                    if (degree[linkedNode]==1){
                        layer.add(linkedNode);
                    }
                }
            }
        }

        return res;
    }

}
