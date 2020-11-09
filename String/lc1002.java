package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc1002 {
    public List<String> commonChars(String[] A) {
        int size=A.length;
        int[][]map=new int[size][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                map[i][A[i].charAt(j)-'a']++;
            }
        }
        List<String>res=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                min=map[j][i]<min?map[j][i]:min;
            }
            for (int j = 0; j < min; j++) {
                res.add(Character.toString((char) ('a'+i)));
            }
        }
        return res;
    }
}
