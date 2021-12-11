package DynamicProgramming;

import java.util.Arrays;

public class lc1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (x, y) -> (x[1] - y[1]));
        int[] dp = new int[jobs.length];

        dp[0] = jobs[0][2];
        int maxProfit = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = jobs[i][2];
            int index = findPreviousCall(i, jobs);
            if (index >= 0){
                dp[i] = Math.max(dp[i - 1], dp[index] + dp[i]);
            }
            else {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;

    }

    private  int findPreviousCall(int index, int[][] jobs){
        int start = 0, end = index - 1, startTime = jobs[index][0], mid, res = -1;
        while (start <= end){
            mid = start + (end - start)/2;
            if(jobs[mid][1] > startTime){
                end = mid - 1;
            }
            else{
                start = mid + 1;
                res = mid;
            }
        }
        return res;
    }


}
