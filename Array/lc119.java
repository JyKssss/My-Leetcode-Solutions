package Array;

import java.util.ArrayList;
import java.util.List;

public class lc119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>res=new ArrayList<>();
        long pre=1;
        for (int i = 0; i <=rowIndex ; i++) {
            if (i==0)res.add(1);
            else {
                pre=((rowIndex-i+1)*pre)/i;
                res.add((int) pre);
            }
        }
        return res;
    }
}
