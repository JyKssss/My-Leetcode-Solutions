package Graph;

import java.util.HashMap;

public class lc839 {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf=new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            String str1=strs[i];
            for (int j = 0; j < i; j++) {
                if (isSimiliar(str1, strs[j])){
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
    public boolean isSimiliar(String str1, String str2){
        int count=0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i)!=str2.charAt(i))count++;
        }
        return count<=2;
    }

    private class UnionFind{
        int count;
        HashMap<Integer,Integer>parentMap;

        public UnionFind(int count) {
            this.count = count;
            this.parentMap=new HashMap<>();
        }

        public int getCount() {
            return count;
        }

        public int find(int node){
            if (!parentMap.containsKey(node)){
                parentMap.put(node, node);
                return node;
            }
            else if (parentMap.get(node)!=node){
                parentMap.put(node, find(parentMap.get(node)));
            }
            return parentMap.get(node);
        }

        public void union(int x,int y){
            int parentX=find(x);
            int parentY=find(y);
            if (parentX!=parentY){
                this.count--;
                parentMap.put(parentY, parentX);
            }
        }
    }
}
