package Math;

import java.util.HashMap;
import java.util.Map;

public class lc781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>keyCountMap=new HashMap<>();
        for (int answer : answers) {
            keyCountMap.put(answer, keyCountMap.getOrDefault(answer, 0)+1);
        }
        int cnt=0;
        for (Map.Entry<Integer, Integer> entry : keyCountMap.entrySet()) {
            cnt+= ((entry.getValue()-1)/(entry.getKey()+1)+1)*(entry.getKey()+1);
        }
        return cnt;
    }
}
