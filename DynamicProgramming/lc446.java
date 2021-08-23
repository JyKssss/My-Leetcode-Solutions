package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class lc446 {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long,Integer>[] mapsList=new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mapsList[i]=new HashMap<>();
        }
        int count=0;
        for (int i = 1; i <nums.length ; i++) {
            int cur=nums[i],prevCnt;
            long diff;
            HashMap<Long,Integer>curMap=mapsList[i];
            for (int j = 0; j < i; j++) {
                diff=(long) cur-(long) nums[j];
                prevCnt=mapsList[j].getOrDefault(diff, 0);
                count+=prevCnt;
                curMap.put(diff, curMap.getOrDefault(diff, 0)+prevCnt+1);
            }
        }

        return count;
    }
}
