package Array;

public class ms1721 {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length], rightMax=new int[height.length];
        int lMax=0,rMax=0,len= height.length;
        for (int i = 0; i < len; i++) {
            if (i==0){
                leftMax[i]=0;
                rightMax[len-1-i]=0;
            }
            else {
                leftMax[i]=lMax;
                rightMax[len-1-i]=rMax;
            }
            lMax=Math.max(lMax, height[i]);
            rMax=Math.max(rMax, height[len-1-i]);
        }
        
        int capacity=0;
        for (int i = 0; i < len; i++) {
            int h=Math.min(leftMax[i],rightMax[i]);
            capacity+= Math.max((h - height[i]), 0);
        }
        return capacity;
    }
}
