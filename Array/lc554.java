package Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer>edgeMap=new HashMap<>();
        for (List<Integer> row : wall) {
            int edge=0;
            for (int i = 0; i < row.size(); i++) {
                if (i<row.size()-1){
                    edge+=row.get(i);
                    edgeMap.put(edge, edgeMap.getOrDefault(edge, 0)+1);
                }
            }
        }
        int max=0;
        for (Integer value : edgeMap.values()) {
            max=Math.max(max, value);
        }
        return wall.size()-max;
    }
}
