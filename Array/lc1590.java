package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc1590 {
    int totalPairs=0;
    public int reversePairs(int[] nums) {
        List<Integer> numslist=new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numslist.add(nums[i]);
        }
        mergeHelper(numslist);
        return totalPairs;
    }
    public List<Integer> mergeHelper(List<Integer> numslist){
        int size=numslist.size();
        if (size==1||size==0)return numslist;
        List<Integer>left=numslist.subList(0, size/2);
        List<Integer>right=numslist.subList(size/2, size);
        List<Integer>sortedList=new ArrayList<>();
        left=mergeHelper(left);
        right=mergeHelper(right);
        int l=0,r=0;
        for (int i = 0; i < size; i++) {
            if (l<left.size()&&r<right.size()){
                int lval=left.get(l);
                int rval=right.get(r);
                if (lval>rval){
                    sortedList.add(rval);
                    r++;
                    totalPairs+=left.size()-l;
                }
                else {
                    sortedList.add(lval);
                    l++;
                }
            }
            else if (l<left.size()){
                sortedList.add(left.get(l));
                l++;
            }
            else if (r<right.size()){
                sortedList.add(right.get(r));
                r++;
            }
        }
        return sortedList;
    }

    public static void main(String[] args) {
        int[] nums={7,5,6,4};
        lc1590 l=new lc1590();
        System.out.println(l.reversePairs(nums));
    }
}
