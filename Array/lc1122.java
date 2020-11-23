package Array;

import java.util.*;

public class lc1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>numMap=new HashMap<>();
        for(int n1:arr1){
            if (numMap.containsKey(n1))numMap.replace(n1, numMap.get(n1)+1);
            else numMap.put(n1, 1);
        }
        List<Integer>l1=new ArrayList<>();
        for(int n2:arr2){
            int num=numMap.get(n2);
            for (int i = 0; i < num; i++) {
                l1.add(n2);
            }
            numMap.remove(n2);
        }
        List<Integer>l2=new ArrayList<>();
        for(int leftN:numMap.keySet()){
            int num=numMap.get(leftN);
            for (int i = 0; i < num; i++) {
                l2.add(leftN);
            }
        }
        Collections.sort(l2);
        l1.addAll(l2);
        int[] res=new int[arr1.length];
        for (int i = 0; i < l1.size(); i++) {
            res[i]=l1.get(i);
        }
        return res;
    }
}
