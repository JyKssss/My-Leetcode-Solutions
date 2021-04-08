package DynamicProgramming;

public class lc410 {
    public int splitArray(int[] nums, int m) {
        int left=nums[0], right=0,mid;
        for (int num : nums) {
            left= Math.max(num, left);
            right+=num;
        }
        while (left<right){
            mid=left+(right-left)/2;
            if (feasibleCut(nums, m, mid)){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return right;
    }

    private boolean feasibleCut(int[] nums, int m,int upperBound){
        int cnt=0,cut=0;
        for (int num : nums) {
            if (cnt+num>upperBound){
                cnt=num;
                cut++;
            }
            else {
                cnt+=num;
            }
        }
        return cut<m;
    }

    public static void main(String[] args) {
        lc410 obj=new lc410();
        int[] nums=new int[]{1,4,4};
        int n=3;
        System.out.println(obj.splitArray(nums, n));
    }
}
