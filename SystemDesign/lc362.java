package SystemDesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class lc362 {
}

class HitCounter {
    PriorityQueue<Integer> heap;
    HashMap<Integer, Integer> timeCountMap;
    int timeLap = 300;
    int count;
    public HitCounter() {
        this.count = 0;
        this.heap = new PriorityQueue<>();
        this.timeCountMap = new HashMap<>();
    }

    public void hit(int timestamp) {
        count += 1;
        if (!timeCountMap.containsKey(timestamp)) {
            heap.offer(timestamp);
        }
        timeCountMap.put(timestamp, timeCountMap.getOrDefault(timestamp, 0) + 1);

    }

    public int getHits(int timestamp) {
        int startTime = timestamp - timeLap;
        HashSet<String>set = new HashSet<>();
        for (String s : set) {
            
        }
        while (heap.size() > 0 && heap.peek() <= startTime) {
            int toDelTime = heap.poll();
            count -= timeCountMap.get(toDelTime);
            timeCountMap.remove(toDelTime);
        }
        return count;
    }
    HashSet<String>set = new HashSet<>();
    
}
