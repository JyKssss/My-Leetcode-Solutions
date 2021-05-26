package Heap;

import javafx.util.Pair;

import java.util.*;

public class lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String>res=new ArrayList<>();
        HashMap<String,Integer>wordsMap=new HashMap<>();
        PriorityQueue<Pair<String,Integer>>heap=new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                if (o1.getValue()!=o2.getValue()){
                    return o1.getValue()-o2.getValue();
                }
                else {
                    return o2.getKey().compareTo(o1.getKey());
                }
            }
        });

        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (heap.size()<k){
                heap.offer(new Pair<>(entry.getKey(), entry.getValue()));
            }
            else {
                heap.offer(new Pair<>(entry.getKey(), entry.getValue()));
                heap.poll();
            }
        }
        while (heap.size()>0){
            res.add(0, heap.poll().getKey());
        }
        return res;
    }
}
