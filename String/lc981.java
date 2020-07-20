package String;

import javafx.util.Pair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc981 {

}

class TimeMap {
    HashMap<Pair<String,Integer>,String>valueMap;
    HashMap<String, List<Integer>>timeMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.valueMap=new HashMap<>();
        this.timeMap=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valueMap.put(new Pair<>(key, timestamp), value);
        if (timeMap.containsKey(key)){
            timeMap.get(key).add(timestamp);
        }
        else{
            List<Integer>time=new ArrayList<>();
            time.add(timestamp);
            timeMap.put(key, time);
        }
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)){
            return new String();
        }
        else {
            List<Integer>times=timeMap.get(key);
            if (times.get(0)>timestamp)return new String();
            int time_prev=findPrevTime(times, 0, times.size()-1, timestamp);

            return valueMap.get(new Pair<>(key, times.get(time_prev)));
        }
    }
    public int findPrevTime(List<Integer>times,int start,int end,int target){
        int mid=(start+end)/2;
        if(times.get(mid)<=target&&(mid==end||times.get(mid+1)>target)){
            return mid;
        }
        int res=0;
        if (times.get(mid)<target){
            res=findPrevTime(times, Math.min(mid+1, end), end, target);
        }
        else if (times.get(mid)>target){
            res=findPrevTime(times, start, Math.max(start, mid-1), target);
        }
        return res;
    }
}
