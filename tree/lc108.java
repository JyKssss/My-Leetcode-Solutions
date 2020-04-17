package tree;

public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0)return null;
        return toBST(nums, 0, nums.length-1);

    }

    public TreeNode toBST(int[] nums,int start,int end){
        if (end-start<0)return null;
        int index=(start+end)/2;
        int val=nums[index];
        TreeNode root=new TreeNode(val);
        if (index>start){
            root.left=toBST(nums, start, index-1);
        }
        else root.left=null;
        if (index<end){
            root.right=toBST(nums, index+1, end);
        }
        else root.right=null;
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
