package GreedyAlgo;

import java.util.HashMap;

public class lc659 {
    public boolean isPossible(int[] nums) {
        if (nums.length<=2)return false;
        HashMap<Integer,Integer>numsCountMap=new HashMap<>();
        HashMap<Integer,Integer>endCountMap=new HashMap<>();
        for(int num:nums){
            if (numsCountMap.containsKey(num))numsCountMap.replace(num, numsCountMap.get(num)+1);
            else numsCountMap.put(num, 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int n=nums[i];
            if (numsCountMap.get(n)>0){
                if (endCountMap.containsKey(n-1)&&endCountMap.get(n-1)>=1){
                    endCountMap.replace(n-1, endCountMap.get(n-1)-1);
                    if (endCountMap.containsKey(n))endCountMap.replace(n, endCountMap.get(n)+1);
                    else endCountMap.put(n, 1);
                    numsCountMap.replace(n, numsCountMap.get(n)-1);
                }
                else {
                    if (numsCountMap.containsKey(n+1)&&numsCountMap.containsKey(n+2)&&numsCountMap.get(n+1)>0&&numsCountMap.get(n+2)>0){
                        numsCountMap.replace(n, numsCountMap.get(n)-1);
                        numsCountMap.replace(n+1, numsCountMap.get(n+1)-1);
                        numsCountMap.replace(n+2, numsCountMap.get(n+2)-1);
                        if (endCountMap.containsKey(n+2))endCountMap.replace(n+2, endCountMap.get(n+2)+1);
                        else endCountMap.put(n+2, 1);
                    }
                    else return false;
                }
            }

        }
        return true;
    }
}
