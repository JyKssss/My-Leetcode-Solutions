package Contest;

import java.util.TreeMap;

public class lc5953 {
    public long subArrayRanges(int[] nums) {
        int[][] maxMatrix = new int[nums.length][nums.length];
        int[][] minMatrix = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxMatrix[i][i] = nums[i];
            minMatrix[i][i] = nums[i];
        }
        for (int len = 2; len < nums.length; len++) {
            for (int i = 0; i < nums.length; i++) {
                if (i + len - 1 < nums.length) {
                    maxMatrix[i][i + len - 1] = Math.max(maxMatrix[i + 1][i + len - 1], maxMatrix[i][i + len - 2]);
                    minMatrix[i][i + len - 1] = Math.min(minMatrix[i + 1][i + len - 1], minMatrix[i][i + len - 2]);
                }
            }
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                total += (maxMatrix[i][j] - minMatrix[i][j]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        lc5953 obj = new lc5953();
        System.out.println(obj.subArrayRanges(new int[]{1,2,3}));
    }
}
