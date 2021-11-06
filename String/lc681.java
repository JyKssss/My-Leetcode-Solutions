package String;



import java.util.HashSet;

public class lc681 {
    public String nextClosestTime(String time) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':'){
                set.add(time.charAt(i));
            }
        }
        time = addOneMinute(time);
        while (!check(time, set)){
            time = addOneMinute(time);
        }
        return time;
    }

    private boolean check(String time, HashSet<Character> set){
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':'){
                if (!set.contains(time.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    private String addOneMinute(String time){
        int[] timeArray =new int[4];
        timeArray[0] = time.charAt(0)-'0';
        timeArray[1] = time.charAt(1)-'0';
        timeArray[2] = time.charAt(3)-'0';
        timeArray[3] = time.charAt(4)-'0';

        boolean isAdd = false;
        for (int i = 3; i >= 0; i--) {
            if (i == 3){
                if (timeArray[i] + 1 == 10){
                    isAdd = true;
                    timeArray[i] = 0;
                }
                else {
                    timeArray[i] += 1;
                }
            }
            if (isAdd){
                if (i == 2){
                    if (timeArray[i] + 1 == 6){
                        isAdd = true;
                        timeArray[i] = 0;
                    }
                    else {
                        timeArray[i] += 1;
                        isAdd =false;
                    }
                }
                else if (i == 1){
                    int hour = 10*timeArray[0] + timeArray[1];
                    if (hour + 1 == 24){
                        hour = 0;
                    }
                    else {
                        hour+=1;
                    }
                    timeArray[0] = hour/10;
                    timeArray[1] = hour%10;
                    isAdd=false;
                }

            }
        }
        String nextMin = timeArray[0] +""+ timeArray[1] +":"+ timeArray[2] +""+ timeArray[3];
        return nextMin;
    }

    public static void main(String[] args) {
        lc681 obj =new lc681();
        String time ="19:34";
        System.out.println(obj.nextClosestTime(time));
    }
}
