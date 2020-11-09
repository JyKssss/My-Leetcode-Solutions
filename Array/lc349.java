package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap();
        for(int n1:nums1)map.put(n1, 0);
        for (int n2:nums2){
            if (map.containsKey(n2)&&map.get(n2)==0){
                res.add(n2);
                map.replace(n2, 1);
            }
        }
        int[] r=new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]=res.get(i);
        }
        return r;
    }
}
