package Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class lc1394 {
    public int findLucky(int[] arr) {
        int lucky=-1;
        HashMap<Integer,Integer>appearNum=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (appearNum.containsKey(arr[i])){
                appearNum.replace(arr[i],appearNum.get(arr[i])+1);
            }
            else {
                appearNum.put(arr[i],1);
            }
        }
        Iterator iterator =appearNum.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer>result=(Map.Entry<Integer,Integer>)iterator.next();
            if (result.getKey()==result.getValue()&& result.getValue()>lucky){
                lucky=result.getValue();
            }
        }
        return lucky;
    }

}
