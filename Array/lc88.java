package Array;

public class lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        for (int i = m-1; i >=0 ; i--) {
            nums1[i+n]=nums1[i];
        }
        int index=0,index1=n,index2=0;
        while (index<len){
            int cur1=index1<len?nums1[index1] : Integer.MAX_VALUE,
            cur2=index2<n?nums2[index2] : Integer.MAX_VALUE;
            if (cur1<=cur2){
                nums1[index]=cur1;
                index1++;
            }
            else {
                nums1[index]=cur2;
                index2++;
            }
            index++;
        }
    }
}
