package Array;

import javax.swing.*;

public class lt460 {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int left=0,right=A.length-1,mid,index=0;
        while (left<right-1){
            mid=left+(right-left)/2;
            int cur=A[mid];
            if (cur>target){
                left=mid;
            }
            else {
                right=mid;
            }
        }
        if (Math.abs(A[left]-target)>Math.abs(A[right]-target)){
            mid=right;
        }
        else {
            mid=left;
        }
        int[] res=new int[k];
        res[index]=A[mid];
        index++;
        right=mid;
        left=mid;
        while (right-left+1<k){
            if (left>0 && right<A.length-1){
                if (Math.abs(A[left-1]-target)<=Math.abs(A[right+1]-target)){
                    left--;
                    res[index]=A[left];
                }
                else {
                    right++;
                    res[index]=A[right];
                }
            }
            else if (left>0){
                left--;
                res[index]=A[left];
            }
            else {
                right++;
                res[index]=A[right];
            }
            index++;
        }

        return res;
    }
}
