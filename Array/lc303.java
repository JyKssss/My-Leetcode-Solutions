package Array;

public class lc303 {
    class NumArray {
        int[] sumArray;
        public NumArray(int[] nums) {
            this.sumArray=new int[nums.length+1];
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                sumArray[i+1]=sum;
            }
        }

        public int sumRange(int i, int j) {
            return sumArray[j+1]-sumArray[i];
        }
    }
}
