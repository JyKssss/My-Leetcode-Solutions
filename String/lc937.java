package String;

import java.util.Arrays;
import java.util.Comparator;

public class lc937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] o1List=o1.split(" ",2),o2List=o2.split(" ",2);
            boolean o1Digit=Character.isDigit(o1List[1].charAt(0)),o2Digit=Character.isDigit(o2List[1].charAt(0));
            if (!o1Digit && !o2Digit){
                if (o1List[1].compareTo(o2List[1])!=0){
                    return o1List[1].compareTo(o2List[1]);
                }
                else {
                    return o1List[0].compareTo(o2List[0]);
                }
            }
            else if (o1Digit && !o2Digit){
                return 1;
            }
            else if (!o1Digit && o2Digit){
                return -1;
            }
            else {
                return 0;
            }

        });
        return logs;
    }
}
