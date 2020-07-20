package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection=new ArrayList<>();
        HashMap<Integer,Integer>hashMap =new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!hashMap.containsKey(nums1[i]))hashMap.put(nums1[i],1);
            else hashMap.replace(nums1[i],hashMap.get(nums1[i])+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])&&hashMap.get(nums2[i])>0){
                intersection.add(nums2[i]);
                hashMap.replace(nums2[i],hashMap.get(nums2[i])-1);
            }
        }
        int [] res=new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            res[i]=intersection.get(i);
        }
        return res;
    }
}
