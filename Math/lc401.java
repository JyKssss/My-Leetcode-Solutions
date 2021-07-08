package Math;

import java.util.ArrayList;
import java.util.List;

public class lc401 {
    public List<String> readBinaryWatch(int turnedOn) {
        int maxHour=Math.min(3, turnedOn);
        List<String>res=new ArrayList<>();
        for (int hour = 0; hour <=maxHour; hour++) {
            int minute=turnedOn-hour;
            List<Integer>hourList=compute(hour, true);
            List<Integer>minuteList=compute(minute, false);
            for (Integer h : hourList) {
                for (Integer min : minuteList) {
                    String time=String.valueOf(h)+":";
                    if (min>=10){
                        time+=String.valueOf(min);
                    }
                    else {
                        time+=("0"+String.valueOf(min));
                    }
                    res.add(time);
                }

            }
        }
        return res;
    }
    private List<Integer> compute(int lightNum, boolean isHour){
        int max=isHour?11:59,bitCount=isHour?4:6;
        List<Integer>timelist=new ArrayList<>();
        search(lightNum, max, 0, bitCount, 0, timelist);
        return timelist;
    }
    private void search(int lightNum, int max, int bit,int bitMax,int time,List<Integer>timeList){
        if (lightNum==0){
            if (time<=max){
                timeList.add(time);
            }
            return;
        }
        else if (bit==bitMax){
            return;
        }
        search(lightNum, max, bit+1, bitMax, time, timeList);
        search(lightNum-1, max, bit+1, bitMax, time|(1<<bit), timeList);
    }
}
