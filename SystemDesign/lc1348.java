package SystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class lc1348 {
}

class TweetCounts {
    HashMap<String, TreeMap<Integer,Integer>>nameCntMap;
    public TweetCounts() {
        this.nameCntMap=new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        if (nameCntMap.containsKey(tweetName)){
            TreeMap<Integer,Integer>timeCntMap=nameCntMap.get(tweetName);
            timeCntMap.put(time, timeCntMap.getOrDefault(time, 0)+1);
        }
        else {
            TreeMap<Integer,Integer>timeCntMap=new TreeMap<>();
            timeCntMap.put(time, 1);
            nameCntMap.put(tweetName,timeCntMap);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int minute=60, hour=3600,day=86400,endChunk,interval,bunchNum;
        List<Integer>res=new ArrayList<>();
        TreeMap<Integer,Integer>timeCntMap=nameCntMap.get(tweetName);
        if (!nameCntMap.containsKey(tweetName)){
            return res;
        }
        if (freq.equals("minute")){
            interval=minute;
            bunchNum=(endTime-startTime)/minute+1;
        }
        else if (freq.equals("hour")){
            interval=hour;
            bunchNum=(endTime-startTime)/hour+1;
        }
        else {
            interval=day;
            bunchNum=(endTime-startTime)/day+1;
        }
        for (int i = 0; i < bunchNum; i++) {
            res.add(0);
        }

        int prevTime=startTime-1,curTime,index;
        while (timeCntMap.higherKey(prevTime)!=null &&
                timeCntMap.higherKey(prevTime)<=endTime){
            curTime=timeCntMap.higherKey(prevTime);
            index=(curTime-startTime)/interval;
            res.set(index, res.get(index)+timeCntMap.get(curTime));
            prevTime=curTime;
        }
        return res;
    }
}
