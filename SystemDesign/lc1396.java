package SystemDesign;

import javafx.util.Pair;

import java.util.HashMap;

public class lc1396 {
    HashMap<Integer,String>enterStationName;//进入地铁站的站名
    HashMap<Integer,Integer>enterStationTime;//进入地铁站的时间
    HashMap<Pair<String,String>,Double>avgTime2Station;//两站之间的平均时间
    HashMap<Pair<String,String>,Integer>nums2station;//两站之间进出的人次
    public lc1396() {
        this.enterStationName=new HashMap<>();
        this.enterStationTime=new HashMap<>();
        this.avgTime2Station=new HashMap<>();
        this.nums2station=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        enterStationName.put(id, stationName);
        enterStationTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String enterStation=enterStationName.get(id);
        int enterTime=enterStationTime.get(id);
        double period=t-enterTime;
        Pair<String,String>enterExitStation=new Pair<>(enterStation, stationName);
        if (avgTime2Station.containsKey(enterExitStation)){
            //更新两站之间的平均时间和次数
            int times=nums2station.get(enterExitStation);
            double avgTime=avgTime2Station.get(enterExitStation);
            avgTime=(avgTime*times+period)/(times+1);

            nums2station.replace(enterExitStation, times+1);
            avgTime2Station.replace(enterExitStation, avgTime);
        }
        else {
            //向map中添加两站之间的时间和次数
            nums2station.put(enterExitStation, 1);
            avgTime2Station.put(enterExitStation, period);
        }
        enterStationName.remove(id);
        enterStationTime.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<String,String>enterExitStation=new Pair<>(startStation, endStation);
        double avgTime=avgTime2Station.get(enterExitStation);
        return avgTime;
    }
}
