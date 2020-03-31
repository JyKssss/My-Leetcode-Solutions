package Array;

/***
 * 双指针 将前p个数调整为不重复的
 */
public class lc26 {
    public int removeDuplicates(int[] nums) {
        int p=0;
        int q=p+1;
        while (q<nums.length){
            if (nums[p]==nums[q]){
                q++;
            }
            else if (nums[p]!=nums[q]){
                p++;
                nums[p]=nums[q];
                q++;
            }
        }
        return p+1;
    }
}
