package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class lc300 {
    /*
    动态规划
     */
    public int lengthOfLIS(int[] nums) {
        int[] dpTable=new int[nums.length];
        int res=1;
        dpTable[0]=1;
        for (int i = 1; i < nums.length ; i++) {
            int max=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    max=Math.max(max, dpTable[j]+1);
                }
            }
            dpTable[i]=max;
            res=Math.max(res, max);
        }
        return res;
    }

    /*
    O(LogN) 二分查找
     */
    public int lengthOfLIS2(int[] nums) {
        List<Integer>longestSeq=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n=nums[i];
            if (longestSeq.size()==0||
                    longestSeq.get(longestSeq.size()-1)<n){
                longestSeq.add(n);
            }
            else {
                int left=0,right=longestSeq.size();
                while (left<right){
                    int mid=left+(right-left)/2,t=longestSeq.get(mid);
                    if (t>=n){
                        right=mid;
                    }
                    else {
                        left=mid+1;
                    }
                }
                longestSeq.set(right, n);
            }
        }
        return longestSeq.size();
    }

}
