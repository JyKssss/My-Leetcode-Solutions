package Array;

public class lc1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] nums=new int[52];
        int cnt=0;
        for (int[] range : ranges) {
            nums[range[0]]++;
            nums[range[1]+1]--;
        }

        for (int i = 1; i <left ; i++) {
            cnt+=nums[i];
        }
        for (int i = left; i <=right ; i++) {
            cnt+=nums[i];
            if(cnt<=0){
                return false;
            }
        }
        return true;
    }
}
