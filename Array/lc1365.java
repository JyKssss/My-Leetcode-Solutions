package Array;

public class lc1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket=new int[101];
        for(int n:nums)bucket[n]++;
        int[] res=new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            int count=0,n=nums[j];
            for (int i = 0; i < n; i++) {
                count+= bucket[i];
            }
            res[j]=count;
        }
        return res;
    }
}
