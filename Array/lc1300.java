package Array;

import java.util.Arrays;

public class lc1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] preSum=new int[arr.length];
        int sum=0;
        //前缀和
        for (int i = 0; i < preSum.length; i++) {
            sum+=arr[i];
            preSum[i]=sum;
        }
        //先找存在于数组中的最小值的范围 二分查找
        int start=0,end=arr.length-1,curSum;
        while (start+1<end){
            int mid=(start+end)/2;
            curSum=preSum[mid]+(arr.length-mid-1)*arr[mid];
            if (curSum>target)end=mid;
            else if(curSum<target)start=mid;
            else return arr[mid];
        }
        int start2=arr[start],end2=arr[end];
        boolean isleft=false;
        //解决两个端点的特殊情况
        if (arr.length*arr[0]>target){
            start2=0;
            end2=arr[0];
            isleft=true;
        }
        if (arr.length*arr[arr.length-1]<target){
            return arr[arr.length-1];
        }
        //二分查找
        while (start2+1<end2){
            int mid=(start2+end2)/2;
            if (!isleft){
                curSum=preSum[start]+(arr.length-start-1)*mid;
                if (curSum>target)end2=mid;
                else if (curSum<target)start2=mid;
                else return mid;
            }
            else {
                curSum=arr.length*mid;
                if (curSum>target)end2=mid;
                else if (curSum<target)start2=mid;
                else return mid;
            }
        }
        System.out.println(start2+" "+end2);
        if (!isleft){
            if (Math.abs(preSum[start]+(arr.length-start-1)*start2-target)<Math.abs(preSum[start]+(arr.length-start-1)*end2-target))return start2;
            else if (Math.abs(preSum[start]+(arr.length-start-1)*start2-target)>Math.abs(preSum[start]+(arr.length-start-1)*end2-target))return end2;
            else return start2;
        }
        else {
            if (Math.abs(arr.length*start2-target)<Math.abs(arr.length*end2-target))return start2;
            else if (Math.abs(arr.length*start2-target)>Math.abs(arr.length*end2-target))return end2;
            else return start2;
        }
    }
}
