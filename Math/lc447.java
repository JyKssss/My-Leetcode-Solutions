package Math;

import java.util.HashMap;

public class lc447 {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer>disMap;
        int count = 0;
        for (int i = 0; i < points.length ; i++) {
            int[] curPoint = points[i];
            disMap = new HashMap<>();
            for (int j = 0; j < points.length ; j++) {
                if (j==i){
                    continue;
                }
                int distance2 = (curPoint[0]-points[j][0])*(curPoint[0]-points[j][0])
                        +(curPoint[1]-points[j][1])*(curPoint[1]-points[j][1]);
                disMap.put(distance2, disMap.getOrDefault(distance2, 0)+1);
            }
            for (Integer times : disMap.values()) {
                if(times >1){
                    count += times*(times-1);
                }
            }
        }
        return count;
    }
}
