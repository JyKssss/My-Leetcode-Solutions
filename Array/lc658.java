package Array;

import java.util.ArrayList;
import java.util.List;

public class lc658 {
    /**
     * 二分查找 之后一定要进行调整找到最中间的那个数再按照K扩展开
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer>res=new ArrayList<>();
        if (arr.length==1){
            res.add(arr[0]);
            return res;
        }
        int start=0,end=arr.length-1,mid=0,count=0;
        while (start<end){
            mid=(start+end)/2;
            if (arr[mid]==x)break;
            else if (arr[mid]>x)end=mid-1;
            else start=mid+1;
        }
        if (arr[mid]!=x){
            if (mid-1>=0&&mid+1<=arr.length-1){
                int cur=mid;
                mid=x-arr[cur-1]>Math.abs(arr[cur]-x)?cur:cur-1;
                mid=Math.abs(arr[mid]-x)>arr[cur+1]-x?cur+1:mid;
            }
            else if (mid==0){
                mid=Math.abs(arr[mid]-x)>arr[mid+1]?mid+1:mid;
            }
            else if (mid==arr.length-1){
                mid=x-arr[mid-1]>Math.abs(arr[mid]-x)?mid:mid-1;
            }
        }
        System.out.println(mid);
        start=mid-1;end=mid+1;count++;
        while (count<k){
            if (start>=0&&end<=arr.length-1){
                if (x-arr[start]>arr[end]-x){
                    end++;
                    count++;
                }
                else {
                    start--;
                    count++;
                }
            }
            else if (start<0){
                end++;
                count++;
            }
            else if (end>arr.length-1){
                start--;
                count++;
            }
        }
        for (int i = start+1; i <end ; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
