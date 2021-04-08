package Array;

public class lc80 {
    public int removeDuplicates(int[] nums) {
        int cnt=0,index=0,len= nums.length,stepLen=0,prev=Integer.MIN_VALUE;
        while (index<len){
            int cur=nums[index];
            if (cur!=prev){
                cnt=1;
                prev=cur;
                nums[index-stepLen]=cur;
            }
            else {
                cnt++;
                if (cnt>2){
                    stepLen++;
                }
                else {
                    nums[index-stepLen]=cur;
                }
            }
            index++;
        }
        return len-stepLen;
    }
}
