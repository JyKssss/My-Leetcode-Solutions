package Math;

import java.util.*;

public class lc179 {
    public String largestNumber(int[] nums) {
        List<String>numsStr=new ArrayList<>();
        for (int num : nums) {
            numsStr.add(String.valueOf(num));
        }

        Collections.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2, s2=o2+o1;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i)!=s2.charAt(i)){
                        return s1.charAt(i)-s2.charAt(i);
                    }
                }
                return 0;
            }
        });
        StringBuffer stringBuffer=new StringBuffer();
        for (String s : numsStr) {
            stringBuffer.insert(0, s);
        }
        while (stringBuffer.charAt(0)=='0'&&stringBuffer.length()>1){
            stringBuffer.deleteCharAt(0);
        }
        return stringBuffer.toString();
    }
}
