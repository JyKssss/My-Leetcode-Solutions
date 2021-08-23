package Contest;

import java.util.*;

public class lc5805 {
    public int smallestChair(int[][] times, int targetFriend) {
        HashMap<Integer,Integer>peopleChairMap=new HashMap<>();//选手查位置
        TreeSet<Integer>chairSet=new TreeSet<>();//未被占位置排序
        for (int i = 0; i < times.length; i++) {
            chairSet.add(i);
        }
//        int[] target=times[targetFriend];
        List<int[]>inOutList=new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            inOutList.add(new int[]{i,times[i][0]});
            inOutList.add(new int[]{i,-times[i][1]});
        }
        Collections.sort(inOutList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Math.abs(o1[1])!=Math.abs(o2[1])){
                    return Math.abs(o1[1])-Math.abs(o2[1]);
                }
                else {
                    return o1[1]-o2[1];
                }
            }
        });

        for (int[] event : inOutList) {
            if (event[0]!=targetFriend){
                if (event[1]>0){
                    int chair=chairSet.pollFirst();
                    peopleChairMap.put(event[0],chair);
                }
                else {
                    int chair=peopleChairMap.get(event[0]);
                    chairSet.add(chair);
                    peopleChairMap.remove(event[0]);
                }
            }
            else{
                return chairSet.first();
            }

        }
        return 0;
    }
}
