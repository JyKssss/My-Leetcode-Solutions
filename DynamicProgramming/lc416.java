package DynamicProgramming;

import java.util.Arrays;

public class lc416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if (sum%2==1)return false;
        boolean[][] dpTable=new boolean[sum/2+1][nums.length+1];
        for (int i = 0; i <=nums.length ; i++) {
            dpTable[0][i]=true;
        }
        //i表示背包的容量  j表示能提供的是前j个数
        for (int i = 1; i <= sum/2; i++) {
            for (int j = 1; j <= nums.length; j++) {
                int num=nums[j-1];
                if (i-num>=0){
                    dpTable[i][j]=dpTable[i][j-1]||
                            dpTable[i-num][j-1];
                }
                else {
                    dpTable[i][j]=dpTable[i][j-1];
                }
            }
        }
        return dpTable[sum/2][nums.length];
    }
}
