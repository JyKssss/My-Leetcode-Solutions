package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc493 {
    //#1 归并排序解法
    int pairCount=0;
    public int reversePairs(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for(int n:nums)list.add(n);
        divide(list);
        return pairCount;
    }

    List<Integer> divide(List<Integer>list){
        if (list.size()<=1)return list;
        List<Integer>l1=divide(list.subList(0, (list.size()/2)));
        List<Integer>l2=divide(list.subList((list.size()/2), list.size()));
        int i1=0,i2=0;
        while (i1<l1.size()){
            while (i2<l2.size()){
                if ((long)l1.get(i1)>2*(long)l2.get(i2))i2++;
                else break;
            }
            pairCount+=i2;
            i1++;
        }
        i1=0;i2=0;
        List<Integer>l=new ArrayList<>();
        while (i1<l1.size()||i2<l2.size()){
            if (i1<l1.size()&&i2<l2.size()){
                if (l1.get(i1)<=l2.get(i2)){
                    l.add(l1.get(i1));
                    i1++;
                }
                else {
                    l.add(l2.get(i2));
                    i2++;
                }
            }
            else if (i1<l1.size()){
                l.add(l1.get(i1));
                i1++;
            }
            else {
                l.add(l2.get(i2));
                i2++;
            }
        }
        return l;
    }
}
