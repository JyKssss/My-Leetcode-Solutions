package Array;

public class ms1710 {
    /**
     * Moore投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate=0,count=0;
        for (int num : nums) {
            if (count==0 && candidate!=num){
                candidate=num;
            }
            else if(candidate!=num){
                count--;
            }
            else {
                count++;
            }
        }

        count=0;
        for (int num : nums) {
            if (num==candidate){
                count++;
            }
        }

        if (count>nums.length/2){
            return candidate;
        }
        else return -1;
    }
}
