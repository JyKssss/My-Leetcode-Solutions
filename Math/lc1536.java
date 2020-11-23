package Math;

import java.util.*;

public class lc1536 {
    public int[] sortByBits(int[] arr) {
        List<Integer>list=new ArrayList<>();
        for(int i:arr)list.add(i);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int b1=bitCompare(o1),b2=bitCompare(o2);
                if (b1!=b2)return b1-b2;
                else return o1-o2;
            }
        });
        int[] res=new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
    private int bitCompare(int number){
        int count=0;
        while (number>0){
            number&=(number-1);
            count++;
        }
        return count;
    }
}
