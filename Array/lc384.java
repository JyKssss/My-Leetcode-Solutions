package Array;


import java.util.Arrays;

public class lc384 {
    int[] array;
    int[] originalArr;
    public lc384(int[] nums) {
        this.array=nums;
        this.originalArr= Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int index=(int) (Math.random()*(array.length-i)+i);
            int tmp=array[index];
            array[index]=array[i];
            array[i]=tmp;
        }
        return array;
    }
}
