package DynamicProgramming;

public class lc125 {
    public int maxProduct(int[] nums) {
        if (nums.length==1)return nums[0];
        int[] maxArr=new int[nums.length];
        int[] minArr=new int[nums.length];
        maxArr[0]=nums[0];
        minArr[0]=nums[0];
        int maxValue=maxArr[0];
        for (int i = 1; i < nums.length; i++) {
            int cur=nums[i],preMin=minArr[i-1],preMax=maxArr[i-1];
            if (cur==0){
                maxArr[i]=0;
                minArr[i]=0;
                maxValue=cur>maxValue?cur:maxValue;
            }
            else if (cur>0){
                if (preMax<0){
                    maxValue=cur>maxValue?cur:maxValue;
                    maxArr[i]=cur;
                    minArr[i]=preMin*cur;
                }
                else if (preMax==0){
                    maxArr[i]=cur;
                    minArr[i]=preMin*cur;
                    maxValue=maxArr[i]>maxValue?maxArr[i]:maxValue;
                }
                else {
                    maxArr[i]=cur*preMax;
                    minArr[i]=preMin*cur;
                    maxValue=maxArr[i]>maxValue?maxArr[i]:maxValue;
                }
            }
            else {
                if (preMax>0){
                    minArr[i]=preMax*cur;
                    maxArr[i]=preMin*cur>cur?preMin*cur:cur;
                    maxValue=maxArr[i]>maxValue?maxArr[i]:maxValue;
                }
                else if (preMax==0){
                    minArr[i]=cur;
                    maxArr[i]=cur*preMin;
                    maxValue=maxArr[i]>maxValue?maxArr[i]:maxValue;
                }
                else {
                    minArr[i]=preMax*cur>cur?cur:preMax*cur;
                    maxArr[i]=preMin*cur;
                    maxValue=maxArr[i]>maxValue?maxArr[i]:maxValue;
                }
            }
        }
        return maxValue;
    }
}
