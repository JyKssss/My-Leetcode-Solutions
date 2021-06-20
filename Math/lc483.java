package Math;

public class lc483 {
    public String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        int len= (int) (Math.log(num+1)/Math.log(2));
        //枚举转换进制后的长度
        for (int i = len; i >=2 ; i--) {
            //二分查找进制
            long start=2, end= (long) Math.pow(num, 1.0/(i-1)+1);
            while (start<end){
                long mid=start+(end-start)/2,sum=0;
                for (int j = 0; j < i; j++) {
                    sum=sum*mid+1;
                }

                if (sum==num){
                    return String.valueOf(mid);
                }
                else if (sum>num){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return String.valueOf(num-1);
    }
}
