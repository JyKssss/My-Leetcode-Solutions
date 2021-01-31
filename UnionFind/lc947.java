package UnionFind;

import java.util.HashMap;

public class lc947 {
    public int removeStones(int[][] stones) {
        Unionfind uf=new Unionfind();
        for (int[] stone:stones){
            uf.union(stone[0]+10001,stone[1]);
        }
        return stones.length-uf.getCount();
    }

    private class Unionfind {
        int count;
        HashMap<Integer,Integer>fatherMap;

        public Unionfind() {
            this.count = 0;
            this.fatherMap=new HashMap<>();
        }

        public int getCount() {
            return count;
        }

        public int find(int x){
            if (!fatherMap.containsKey(x)){
                fatherMap.put(x,x);
                count++;
                return x;
            }
            else if (x==fatherMap.get(x)){
                return x;
            }
            else {
                fatherMap.put(x,find(fatherMap.get(x)));
            }
            return fatherMap.get(x);
        }


        public void union(int x, int y){
            int fatherX=find(x);
            int fatherY=find(y);
            if (fatherX==fatherY)return;
            else {
                fatherMap.put(fatherX, fatherY);
                count--;
            }
            return;
        }
    }
}
