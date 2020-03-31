package Array;

import org.omg.Messaging.SyncScopeHelper;

public class lc11 {
    public static void main(String[] args) {
        int[] input= {2,3,4,5,18,17,6};
        maxArea(input);

    }

    public static int maxArea(int[] height) {
        int size = height.length;
        if (size<2){
            return 0;
        }
        int left =0;
        int right = size-1;
        int maxVol = Math.min(height[left], height[right])*(right -left);
        int curVol;
        while (left!=right){
            if (height[left]>height[right]){
                right--;
            }
            else {
                left++;
            }
            curVol = Math.min(height[left], height[right])*(right -left);
            System.out.println(curVol);
            if (curVol>maxVol){
                maxVol =curVol;
//                System.out.println(maxVol);
            }
        }
        return maxVol;
    }

}
