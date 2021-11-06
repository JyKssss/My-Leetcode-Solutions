package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lc253 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0],1});
            list.add(new int[]{interval[1],-1});
        }
        list.sort((o1, o2) -> o1[0]-o2[0]);
        int curTime = list.get(0)[0], maxRoom = 0, curRoom = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == curTime){
                curRoom += list.get(i)[1];
            }
            else {
                maxRoom = Math.max(maxRoom, curRoom);
                curTime = list.get(i)[0];
                curRoom += list.get(i)[1];
            }
        }
        return maxRoom;
    }
}
