package String;

import java.util.Arrays;

public class lc1736 {
    public String maximumTime(String time) {
        char[] timeArray=time.toCharArray();
        for (int i = 0; i < timeArray.length; i++) {
            if (i==0 && timeArray[i]=='?'){
                if (timeArray[i+1]!='?'){
                    if (timeArray[i+1]-'0'>3){
                        timeArray[i]='1';
                    }
                    else {
                        timeArray[i]='2';
                    }
                }
                else {
                    timeArray[i]='2';
                    timeArray[i+1]='3';
                    i++;
                }
            }

            if (i==1 && timeArray[i]=='?'){
                if (timeArray[i-1]=='2'){
                    timeArray[i]='3';
                }
                else {
                    timeArray[i]='9';
                }
            }

            if (i==2){
                continue;
            }

            if (i==3 && timeArray[i]=='?'){
                timeArray[i]='5';
            }

            if (i==4 && timeArray[i]=='?'){
                timeArray[i]='9';
            }
        }

        return String.valueOf(timeArray);
    }
}
