package Matrix;

import java.util.*;

public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        int res=0;
        if (envelopes.length<=1)return envelopes.length;
        List<int[]>sortEnvelopes=new ArrayList<>();
        for(int[] envelope:envelopes){
            sortEnvelopes.add(envelope);
        }
        Collections.sort(sortEnvelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                else {
                    return o2[1]-o1[1];
                }
            }
        });
        int[] dpTable=new int[envelopes.length];
        dpTable[0]=1;
        for (int i = 1; i < dpTable.length; i++) {
            int max=1, col=sortEnvelopes.get(i)[1];
            for (int j = 0; j < i; j++) {
                if (sortEnvelopes.get(j)[1]<col){
                    max=Math.max(max, 1+dpTable[j]);
                }
            }
            dpTable[i]=max;
            res=Math.max(res, dpTable[i]);
        }
        return res;
    }

    //二分查找解决最长递增子序列O(NlogN)
    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes.length<=1)return envelopes.length;
        List<int[]>sortEnvelopes=new ArrayList<>();
        for(int[] envelope:envelopes){
            sortEnvelopes.add(envelope);
        }
        Collections.sort(sortEnvelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                else {
                    return o2[1]-o1[1];
                }
            }
        });
        int[] array=new int[sortEnvelopes.size()];
        for (int i = 0; i < array.length; i++) {
            array[i]=sortEnvelopes.get(i)[1];
        }
        List<Integer>longestSeq=new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (longestSeq.size()==0||longestSeq.get(longestSeq.size()-1)<array[i]){
                longestSeq.add(array[i]);
            }
            int cur=array[i],left=0,right=longestSeq.size();
            while (left<right){
                int mid=left+(right-left)/2,tmp=longestSeq.get(mid);
                if (tmp>=cur){
                    right=mid;
                }
                else {
                    left=mid+1;
                }

            }
            longestSeq.set(right, cur);
        }
        return longestSeq.size();
    }
}
