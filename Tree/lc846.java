package Tree;

import java.util.TreeMap;

public class lc846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W!=0){
            return false;
        }
        TreeMap<Integer,Integer>handMap=new TreeMap<>();
        for (int i : hand) {
            handMap.put(i, handMap.getOrDefault(i, 0)+1);
        }
        while (handMap.size()>0){
            int cur=handMap.firstKey();
            deleteCard(handMap, cur);
            for (int i = 0; i < W-1; i++) {
                cur++;
                if (!handMap.containsKey(cur)){
                    return false;
                }
                else {
                    deleteCard(handMap, cur);
                }
            }
        }
        return true;
    }

    private void deleteCard(TreeMap<Integer,Integer>handMap,int key){
        if (handMap.get(key)>1){
            handMap.put(key, handMap.get(key)-1);
        }
        else {
            handMap.remove(key);
        }
    }
}
