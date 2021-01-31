package Graph;

import java.util.*;

public class lc1631 {
    public int minimumEffortPath(int[][] heights) {
        int size= heights.length*heights[0].length,width=heights[0].length;
        List<edge>edgesList=new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < width; j++) {
                if (j>0){
                    int value=Math.abs(heights[i][j]-heights[i][j-1]);
                    int start=i*width+j-1,end=i*width+j;
                    edgesList.add(new edge(start, end, value));
                }
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (j>0){
                    int value=Math.abs(heights[j][i]-heights[j-1][i]);
                    int start=(j-1)*width+i,end=j*width+i;
                    edgesList.add(new edge(start, end, value));
                }
            }
        }
        Collections.sort(edgesList, new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.value-o2.value;
            }
        });

        int start=0,end=size-1;
        UnionFind uf=new UnionFind();
        for (edge e:edgesList){
            uf.merge(e.start, e.end);
            if (uf.find(start)==uf.find(end))return e.value;
        }
        return 0;
    }

    private class edge{
        int start;
        int end;
        int value;

        public edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

    }

    private class UnionFind{
        HashMap<Integer,Integer>parentMap;

        public UnionFind() {
            this.parentMap=new HashMap<>();
        }

        public int find(int node){
            if (!parentMap.containsKey(node)){
                parentMap.put(node, node);
                return node;
            }
            else if (parentMap.get(node)!=node){
                parentMap.put(node, find(parentMap.get(node)));
                return parentMap.get(node);
            }
            else return node;
        }

        public void merge(int x,int y){
            int parentX=find(x);
            int parentY=find(y);
            if (parentX!=parentY){
                parentMap.put(parentY, parentX);
            }
        }
    }
}
