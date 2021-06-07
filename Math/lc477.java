package Math;

public class lc477 {
    public int totalHammingDistance(int[] nums) {
        int total= nums.length,res=0;
        int[] countArr=new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                countArr[i]+=num&1;
                num=num>>>1;
            }
        }
        for (int i : countArr) {
            res+=(total-i)*i;
        }
        return res;
    }
}
