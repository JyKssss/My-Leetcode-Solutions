package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc539 {
    /**
     * 将时间转换为分钟 并排序 且要比较开始和结尾时间
     * 排序求快可以用桶排序 但必须是大量数据
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {
        int leastInterval=Integer.MAX_VALUE;
        List<Integer>minutes=new ArrayList<>();
        for(String hm:timePoints){
            int hour=Integer.valueOf(hm.split(":")[0]);
            int minute=Integer.valueOf(hm.split(":")[1]);
            minutes.add(hour*60+minute);
        }
        Collections.sort(minutes);
        int pre=minutes.get(0);
        for (int i = 1; i < minutes.size(); i++) {
            int cur=minutes.get(i);
            if (cur-pre<leastInterval)leastInterval=cur-pre;
            pre=cur;
        }

        if (leastInterval>Math.min(24*60-minutes.get(minutes.size()-1)+minutes.get(0), minutes.get(minutes.size()-1)-minutes.get(0))){
            return Math.min(24*60-minutes.get(minutes.size()-1)+minutes.get(0), minutes.get(minutes.size()-1)-minutes.get(0));
        }
        return leastInterval;
    }

    public int findMinDifference2(List<String> timePoints) {
        int leastInterval=Integer.MAX_VALUE;
        List<Integer>minutes=new ArrayList<>();
        for(String hm:timePoints){
            int hour=Integer.valueOf(hm.split(":")[0]);
            int minute=Integer.valueOf(hm.split(":")[1]);
            minutes.add(hour*60+minute);
        }
        int[] bucksSort=new int[60*24];
        for(Integer min:minutes){
            bucksSort[min]++;
        }
        int interval=0,count=0,last=0,start=0;
        for (int i = 0; i < bucksSort.length; i++) {
            if (bucksSort[i]>1)return 0;
            else if (bucksSort[i]==1){
                interval++;
                if (interval<leastInterval&&count>0)leastInterval=interval;
                if (count==0)start=i;
                interval=0;
                count++;
                last=i;
            }
            else interval++;
        }
        System.out.println(start+" "+last);
        if (leastInterval>Math.min(24*60-last+start,last-start)){
            return Math.min(24*60-last+start,last-start);
        }
        return leastInterval;
    }
}
