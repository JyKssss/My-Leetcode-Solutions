package SystemDesign;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class lc460 {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(0);
        lfuCache.put(0, 0);
        lfuCache.get(0);
//        lfuCache.put(3, 3);
//        lfuCache.get(2);
//        lfuCache.get(3);
//        lfuCache.put(4, 4);
    }
}

class LFUCache {
    HashMap<Integer, Integer> kvMap;
    HashMap<Integer, Integer> kFrepMap;
    TreeMap<Integer, LinkedHashSet<Integer>> orderKeyMap;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.kvMap = new HashMap<>();
        this.kFrepMap = new HashMap<>();
        this.orderKeyMap = new TreeMap<>();
    }

    public int get(int key) {
//        System.out.println("Get : " + key);
        Integer val = kvMap.get(key);
        if (val != null) {
            increaseFreq(key);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            increaseFreq(key);
            kvMap.put(key, value);
        } else {
            if (capacity == 0) {
                return;
            }
            if (kvMap.size() == capacity) {
                deleteLeastFreqKey();
            }
            kvMap.put(key, value);
            kFrepMap.put(key, 1);
            orderKeyMap.putIfAbsent(1, new LinkedHashSet<>());
            orderKeyMap.get(1).add(key);
        }
    }

    private void increaseFreq(int key) {
        int freq = kFrepMap.get(key);
        kFrepMap.put(key, freq + 1);
        LinkedHashSet<Integer> keySet = orderKeyMap.get(freq);
        keySet.remove(key);
        if (keySet.size() == 0) {
            orderKeyMap.remove(freq);
        }
        orderKeyMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
        orderKeyMap.get(freq + 1).add(key);
    }

    private void deleteLeastFreqKey() {
        LinkedHashSet<Integer> keySet = orderKeyMap.firstEntry().getValue();
        int deleteKey = keySet.iterator().next();
        kvMap.remove(deleteKey);
        kFrepMap.remove(deleteKey);
        keySet.remove(deleteKey);

        if (keySet.size() == 0) {
            orderKeyMap.remove(orderKeyMap.firstKey());
        }
    }
}
