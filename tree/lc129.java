package tree;

public class lc129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int sum){
        if (root==null)return 0;
        int tmp=sum*10+root.val;
        if (root.left==null&&root.right==null){
            return tmp;
        }
        else return helper(root.left,tmp)+helper(root.right, tmp);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
