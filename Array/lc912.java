package Array;

import java.util.Arrays;

//归并排序数组
public class lc912 {
    public int[] sortArray(int[] nums) {
        if (nums.length<=1){
            return nums;
        }
        int length=nums.length;
        int[]left= Arrays.copyOfRange(nums, 0, (length/2));

//        for (int i = 0; i < left.length; i++) {
//            System.out.println("left:"+left[i]);
//        }
        int[]right=Arrays.copyOfRange(nums, (length/2), length);

        int[]sortedLeft=sortArray(left);
        int[]sortedRight=sortArray(right);
        for (int i = 0; i < sortedLeft.length; i++) {
            System.out.println(sortedLeft[i]);
        }
        int[]sorted=new int[length];
        int j=0,k=0;
        for (int i = 0; i < sorted.length; i++) {
            if (sortedLeft[j]<=sortedRight[k]){
                sorted[i]=sortedLeft[j];
                if (j<sortedLeft.length-1)j++;
            }
            else {
                sorted[i]=sortedRight[k];
                if (k<sortedRight.length-1)k++;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] nums={5,2,4,1};
        lc912 n=new lc912();
        int[] result=n.sortArray(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(result[i]);
        }
    }

}
