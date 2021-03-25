package Recursion;

import java.util.*;

public class lc1387 {
    HashMap<Integer,Integer>powerMemory;
    int lo,hi;
    public int getKth(int lo, int hi, int k) {
        this.powerMemory=new HashMap<>();
        this.lo=lo;
        this.hi=hi;

        List<int[]>powerList=new ArrayList<>();
        for (int i = lo; i <=hi ; i++) {
            powerList.add(new int[]{getPower(i),i});
        }
        Collections.sort(powerList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        return powerList.get(k-1)[1];
    }

    public int getPower(int n){
        int power;
        if (powerMemory.containsKey(n)){
            return powerMemory.get(n);
        }
        else {
            if (n==1){
                return 0;
            }
            else if (n%2==1){
                power=getPower(3*n+1)+1;
                if (n>=lo && n<=hi){
                    powerMemory.put(n, power);
                }
                return power;
            }
            else {
                power=getPower(n/2)+1;
                if (n>=lo && n<=hi){
                    powerMemory.put(n, power);
                }
                return power;
            }
        }
    }
}
