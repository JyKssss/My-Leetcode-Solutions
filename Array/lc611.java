package Array;

import java.util.Arrays;

public class lc611 {
    public int triangleNumber(int[] nums) {
        int count=0;
        if (nums.length<=2)return 0;
        int p,q,r,l1,l2,l3;
        Arrays.sort(nums);
        for ( p = 0; p <nums.length-2 ; p++) {
            l1=nums[p];
            q=p+1;
            r=q+1;
            for ( q=p+1 ; q <nums.length-1 ; q++) {
                if (r==nums.length-1)count+=(r-q);

                if (r==q && r<nums.length-1)r++;
                else {
                    while (l1+nums[q]>nums[r]){
                        r++;
                        if (r==nums.length)break;
                    }
                    count+=r-q-1;
                    if (r-q-1>0)r--;


                }
            }
        }
        return count;
    }

    public int triangleNumber2(int[] nums) {
        int p1,p2,p3,l1,l2,l3,count=0,target,end,mid,res=0;
        if (nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        for ( p3 = 2; p3 <nums.length ; p3++) {
            l3=nums[p3];
            p1=0;
            for ( p2=p3-1 ; p2 >0 ; p2--) {
                l2=nums[p2];
                target=l3-l2;
                end=p2-1;
                p1=res;
                res=p2;
                while (p1<=end){
                    mid=p1+(end-p1)/2;
                    if (nums[mid]>target){
                        end=mid-1;
                        res=mid;
                    }
                    else {
                        p1=mid+1;
                    }
                }
                count+=(p2-res);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        lc611 obj=new lc611();
        int[] nums=new int[]{24,3,82,22,35,84,19};
        System.out.println(obj.triangleNumber2(nums));
    }
}
