package Tree;

public class lc124 {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }
    public int maxPathSumHelper(TreeNode root) {
        if (root==null)return 0;

        int left=Math.max(0, maxPathSumHelper(root.left));
        int right=Math.max(0, maxPathSumHelper(root.right));

        ans=Math.max(ans, left+right+ root.val);
        return Math.max(left, right)+ root.val;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



