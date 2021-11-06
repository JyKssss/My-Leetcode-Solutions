package Tree;

import java.util.HashSet;

public class lc156 {
    TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        helper(root);
        return newRoot;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null || root.left == null){
            this.newRoot = root;
            return root;
        }
        TreeNode left = root.left, right = root.right;
        left = helper(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return left.right;
    }
}
