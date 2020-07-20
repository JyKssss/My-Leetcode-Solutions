package Array;

public class lc45 {
    public int jump(int[] nums) {
        int count=0,index=0,len=0,maxIndex=0,nextIndex=0;
        if (nums.length==1)return 0;
        while (index<nums.length-1){
            len=nums[index];
            if (index+len>=nums.length){
                return count+1;
            }
            for (int i = 1; i <=len ; i++) {
                if (index+i+nums[index+i]>maxIndex){
                    maxIndex=index+i+nums[index+i];
                    nextIndex=index+i;
                }
            }
            index=nextIndex;
            count++;
        }
        return count;
    }
}
