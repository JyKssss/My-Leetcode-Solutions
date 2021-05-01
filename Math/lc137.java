package Math;

public class lc137 {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int total=0;
            for (int num : nums) {
                total+=(num>>i)&1;
            }

            if (total%3==1){
                ans|= (1<<i);
            }
        }
        return ans;
    }
}
