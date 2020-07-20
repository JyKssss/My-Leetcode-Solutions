package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class lc274 {
    public int hIndex(int[] citations) {
        Integer[] cit=new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cit[i]=citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());
        int res=0;
        for (int i = 0; i < cit.length; i++) {
            if (cit[i]>=i+1)res=i+1;
            else break;
        }
        return res;
    }
    //桶排序提速
    public int hIndex2(int[] citations) {
        int[] buckle=new int[citations.length+1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>=citations.length)buckle[citations.length]++;
            else buckle[citations[i]]++;
        }
        int count=0;
        for (int i = citations.length; i >=0; i--) {
            count+=buckle[i];
            if (count<i)continue;
            else return i;
        }
        return 0;
    }
}
