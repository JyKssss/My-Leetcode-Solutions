package Tree;

public class lc783 {
    int min=100000;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        prev=null;
        helper(root);
        return min;
    }
    private void helper(TreeNode node){
        if (node==null){
            return;
        }
        helper(node.left);
        if (prev!=null){
            min=Math.min(min, node.val-prev.val);
        }
        prev=node;
        helper(node.right);
    }
}
