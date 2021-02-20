package Array;

import java.util.Arrays;

public class lc566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int size= nums.length*nums[0].length;
        if (size!=r*c)return nums;
        else {
            int[][] mat=new int[r][c];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    int rank=i* nums[0].length+j;
                    mat[rank/c][rank%c]=nums[i][j];
                }
            }
            return mat;
        }
    }
}
