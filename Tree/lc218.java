package Tree;

import java.util.*;

public class lc218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>res=new ArrayList<>();
        List<int[]>eventList=new ArrayList<>();
        TreeMap<Integer,Integer>heightMap=new TreeMap<>();
        for (int[] building : buildings) {
            int left=building[0],right=building[1],height=building[2];
            eventList.add(new int[]{left,height});
            eventList.add(new int[]{right,-height});
        }

        Collections.sort(eventList, (o1, o2) -> {
            if (o1[0]==o2[0]){
                return o2[1]-o1[1];
            }
            else {
                return o1[0]-o2[0];
            }
        });

        for (int[] event : eventList) {
//            System.out.println("Event : "+ event[0]+" ,"+event[1]);
            boolean isStart= event[1] > 0;
            int height=Math.abs(event[1]),highestH;
            if (isStart){
                highestH=heightMap.isEmpty()?0:heightMap.lastKey();
                if (height>highestH){
                    List<Integer>node=new ArrayList<>();
                    node.add(event[0]);
                    node.add(height);
                    res.add(node);
                }
                heightMap.put(height, heightMap.getOrDefault(height, 0)+1);
            }
            else {
                if (heightMap.get(height)>1){
                    heightMap.put(height, heightMap.get(height)-1);
                }
                else {
                    heightMap.remove(height);
                }
                highestH=heightMap.isEmpty()?0:heightMap.lastKey();
                if (height>highestH){
                    List<Integer>node=new ArrayList<>();
                    node.add(event[0]);
                    node.add(highestH);
                    res.add(node);
                }

            }
        }
        return res;
    }
}
