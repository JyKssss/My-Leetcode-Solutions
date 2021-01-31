package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //两个HashMap
        // #1 记录email-序号
        // #2 记录email-name
        HashMap<String,Integer>emailNoMap=new HashMap<>();
        HashMap<String,String>emailNameMap=new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String>account=accounts.get(i);
            for (int j = 0; j < account.size(); j++) {
                String name=null;
                if (j==0)name=account.get(j);
                else {
                    if (emailNoMap.containsKey(account.get(j)))continue;
                    emailNoMap.put(account.get(j), i);
                    emailNameMap.put(account.get(j), name);
                }
            }
        }
//        把各个account进行union
        UnionFind uf =new UnionFind();
        for (int i = 0; i < accounts.size(); i++) {
            List<String>account=accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email=account.get(j);
                int id=emailNoMap.get(email);
                if (id!=i)uf.union(id, i);
            }
        }

        HashMap<Integer, HashSet<String>>resMap=new HashMap<>();
        HashMap<Integer,List<String>>resListMap=new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String>account=accounts.get(i);
            int parent=uf.find(i);
            if (!resMap.containsKey(parent)){
                HashSet<String>nameSet=new HashSet<>();
                List<String>nameList=new ArrayList<>();
                for (int j = 1; j < account.size(); j++) {
                    if (nameSet.contains(account.get(j)))continue;
                    nameSet.add(account.get(j));
                    nameList.add(account.get(j));
                }
                resMap.put(parent, nameSet);
                resListMap.put(parent, nameList);
            }
            else {
                HashSet<String>nameSet=resMap.get(parent);
                List<String>nameList=resListMap.get(parent);
                for (int j = 1; j < account.size(); j++) {
                    if (nameSet.contains(account.get(j)))continue;
                    nameSet.add(account.get(j));
                    nameList.add(account.get(j));
                }
            }
        }
        List<List<String>>resList=new ArrayList<>();
        for(Integer id:resMap.keySet()){
            String name=accounts.get(id).get(0);
            List<String>oneUser=new ArrayList<>();
            oneUser.add(name);
            List<String>emailList=resListMap.get(id);
            for(String email:emailList){
                oneUser.add(email);
            }
            resList.add(oneUser);
        }
        return resList;
    }

    private class UnionFind{
        HashMap<Integer,Integer>parentMap;

        public UnionFind() {
            this.parentMap=new HashMap<>();
        }

        public HashMap<Integer, Integer> getParentMap() {
            return parentMap;
        }

        public int find(int x){
            if (!parentMap.containsKey(x)){
                parentMap.put(x, x);
                return x;
            }
            else if (parentMap.get(x)!=x){
                parentMap.put(x, find(parentMap.get(x)));
            }
            else {
                return x;
            }
            return parentMap.get(x);
        }

        public void union(int x, int y){
            int parentX=find(x);
            int parentY=find(y);
            if (parentX==parentY)return;
            else parentMap.put(parentY, parentX);
            return;
        }
    }
}
