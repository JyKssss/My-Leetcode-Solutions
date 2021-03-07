package Contest;

public class lc5691 {
    public int minOperations(int[] nums1, int[] nums2) {
        int smallLen= nums1.length>= nums2.length? nums2.length : nums1.length, longLen= nums1.length>= nums2.length? nums1.length : nums2.length;
        if (6*smallLen<longLen){
            return -1;
        }
        int[] cnt1=new int[7], cnt2=new int[7];
        int sum1=0,sum2=0;
        for (int n1: nums1){
            cnt1[n1]++;
            sum1+=n1;
        }
        for(int n2: nums2){
            cnt2[n2]++;
            sum2+=n2;
        }

        int[] maxNums=sum1>=sum2? cnt1:cnt2,minNums=sum1>=sum2?cnt2: cnt1;
        int maxSum=sum1>=sum2?sum1:sum2, minSum=sum1>=sum2?sum2:sum1, cnt=0, index=0;
        while (maxSum>minSum){
            if (maxNums[6-index]-->0){
                maxSum-=(6-index-1);
                cnt++;
            }
            else if (minNums[1+index]-->0){
                minSum+=(6-1-index);
                cnt++;
            }
            else {
                index++;
            }

        }
        return cnt;
    }
}
