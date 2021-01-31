package Graph;

import java.util.*;

public class lc778 {
    public int swimInWater(int[][] grid) {
        int length= grid.length,min= Math.max(grid[0][0],grid[length-1][length-1]);


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
        HashMap<Integer,Integer> parentMap;

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
