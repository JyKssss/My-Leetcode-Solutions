package SystemDesign;

import java.util.*;

public class lc981 {

}

class TimeMap {
    HashMap<String, TreeMap<Integer,String>>timeMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.timeMap=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String>treeMap=timeMap.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        timeMap.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String>treeMap=timeMap.getOrDefault(key, null);
        if (treeMap!=null){
           Map.Entry<Integer,String> entry=treeMap.floorEntry(timestamp);
           if (entry!=null){
               return entry.getValue();
           }
           else {
               return "";
           }
        }
        else {
            return "";
        }
    }
}
