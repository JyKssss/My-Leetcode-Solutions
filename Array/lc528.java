package Array;

import java.lang.annotation.Target;

public class lc528 {

}
class Solution {
    int[] aggWeight;
    int max;
    public Solution(int[] w) {
        int agg=0;
        aggWeight=new int[w.length+1];
        for (int i = 0; i < w.length; i++) {
            agg+=w[i];
            aggWeight[i+1]=agg;
        }
        max=agg;
    }

    public int pickIndex() {
        int random=(int)(Math.random()*max);
        int start=0,end=aggWeight.length-1,index=0;
        while (start<end){
            int mid=(start+end)/2;
            if (start==mid){
                index=mid;
                break;
            }
            if (mid-start==1&&random>=aggWeight[start]&&random<aggWeight[mid]){
                index=start;
                break;
            }
            if (end-mid==1&&random>=aggWeight[mid]&&random<aggWeight[end]){
                index=mid;
                break;
            }
            if (aggWeight[mid]>random){
                end=mid;
            }
            else if (aggWeight[mid]<random){
                start=mid;
            }
            else {
                index=mid;
                break;
            }
        }
        return index;
    }
}

