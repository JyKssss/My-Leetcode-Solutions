package Array;

public class lc1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum=new int[arr.length+1];
        int oddSum=0,oddCnt=0, evenSum=0,evenCnt=1,sum=0;
        for (int i = 1; i <= arr.length; i++) {
            int cur=arr[i-  1]+preSum[i-1];
            if (i%2==1){
                sum+=(cur*evenCnt-evenSum);
                oddSum+=cur;
                oddCnt+=1;
            }
            else {
                sum+=(cur*oddCnt-oddSum);
                evenSum+=cur;
                evenCnt+=1;
            }
            preSum[i]=cur;
        }
        return sum;
    }

    public static void main(String[] args) {
        lc1588 obj= new lc1588();
        System.out.println(obj.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
