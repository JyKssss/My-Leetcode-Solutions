package Array;

import java.util.ArrayList;
import java.util.List;

public class lc315 {
    public List<Integer> countSmaller(int[] nums) {
        num[] numsArray=new num[nums.length];
        List<Integer>res=new ArrayList<>();
        if (nums.length==0)return res;
        if (nums.length==1){
            res.add(0);
            return res;
        }
        int[] resArray=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArray[i]=new num(nums[i],i);
        }
        sort(0, numsArray.length-1, numsArray);
        for (int i = 0; i < numsArray.length; i++) {
            resArray[numsArray[i].index]=numsArray[i].count;
        }
        for (int i = 0; i < resArray.length; i++) {
            res.add(resArray[i]);
        }
        return res;
    }
    public void sort(int start,int end, num[] numsArray){
        if (start<end){
            int mid=(start+end)/2;
            sort(start, mid, numsArray);
            sort(mid+1, end, numsArray);
            merge(start, mid, end, numsArray);
        }
    }
    public void merge(int start,int mid, int end, num[] numsArray){
        num[] tmp=new num[end-start+1];
        int left=start,right=mid+1,tmpIndex=0;
        while (left<=mid||right<=end){
            if (left<=mid&&right<=end){
                if (numsArray[left].val<=numsArray[right].val){
                    tmp[tmpIndex]=numsArray[left];
                    tmp[tmpIndex].count+=right-mid-1;
                    left++;
                    tmpIndex++;

                }
                else {
                    tmp[tmpIndex]=numsArray[right];
                    right++;
                    tmpIndex++;
                }
            }
            else if (right<=end){
                tmp[tmpIndex]=numsArray[right];
                right++;
                tmpIndex++;
            }
            else if (left<=mid){
                tmp[tmpIndex]=numsArray[left];
                tmp[tmpIndex].count+=right-mid-1;
                left++;
                tmpIndex++;
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            numsArray[i+start]=tmp[i];
        }
    }
}

class num {
    int val;
    int index;
    int count;
    public num(int val,int index){
        this.val=val;
        this.index=index;
        this.count=0;
    }
}
