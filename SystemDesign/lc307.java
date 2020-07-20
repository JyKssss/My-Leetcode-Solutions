package SystemDesign;

/**
 * 线段树建树
 * RangeSum 主要判断左边界是不是右孩子 以及 右边界是不是左孩子
 */
public class lc307 {

}

class NumArray {
    int[] tree;
    int len;
    public NumArray(int[] nums) {
        len=nums.length;
        tree=new int[len*2];
        buildTree(nums);
    }
    public void buildTree(int[] nums) {
        for (int i = 0; i <len ; i++) {
            tree[len+i]=nums[i];
        }
        for (int i = len-1; i >0 ; i--) {
            tree[i]=tree[2*i]+tree[2*i+1];
        }
    }

    public void update(int i, int val) {
        int diff=val-tree[i+len];
        i+=len;
        while (i>0){
            tree[i]+=diff;
            i=i/2;
        }
    }

    public int sumRange(int i, int j) {
        i+=len;
        j+=len;
        int sum=0;
        while (i<=j){
            if (i%2==1){
                sum+=tree[i];
                i++;
            }
            if (j%2==0){
                sum+=tree[j];
                j--;
            }
            i/=2;
            j/=2;
        }
        return sum;
    }
}

