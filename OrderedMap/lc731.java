package OrderedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class lc731 {

}

/**
 * TreeMap储存每个节点开始直至下个节点的任务数
 * 每一次book更新节点
 */
class MyCalendarTwo {
    TreeMap<Integer,Integer>taskMap;
    public MyCalendarTwo() {
        this.taskMap=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer>floor= taskMap.floorEntry(start);
        if (floor==null||floor.getValue()<2){
            return insertBook(taskMap, start, end, floor==null?0: floor.getValue());
        }
        else {
            return false;
        }
    }

    private boolean insertBook(TreeMap<Integer,Integer>taskMap,int start,int end,int floorValue){
        int cur=start,prev=0;
        List<Integer>addList=new ArrayList<>();
        while (cur<end){
            Map.Entry<Integer,Integer>ceiling= taskMap.higherEntry(cur);
            if (ceiling==null){
                break;
            }
            if (ceiling.getKey()<end&&ceiling.getValue()>=2){
                return false;
            }
            if (ceiling.getKey()<end){
                addList.add(ceiling.getKey());
            }
            cur=ceiling.getKey();
        }

        taskMap.put(start, floorValue+1);
        prev=floorValue+1;
        for (Integer integer : addList) {
            taskMap.put(integer, taskMap.get(integer)+1);
            prev=taskMap.get(integer);
        }
        if (!taskMap.containsKey(end)){
            taskMap.put(end, prev-1);
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo calendarTwo=new MyCalendarTwo();
        int[][] tasks=new int[][]{{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(calendarTwo.book(tasks[i][0],tasks[i][1]));
        }
    }
}
