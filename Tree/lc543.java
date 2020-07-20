package Tree;

public class lc543 {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeHelper(root)-1;
    }
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root==null)return 0;

        int lmax= diameterOfBinaryTreeHelper(root.left);
        int rmax= diameterOfBinaryTreeHelper(root.right);
        int lheight=heightHelper(root.left);
        int rheight=heightHelper(root.right);
        return Math.max(Math.max(lmax, rmax), 1+lheight+rheight);
    }
    public int heightHelper(TreeNode root){
        if (root==null)return 0;
        int height=1;
        height+=Math.max(heightHelper(root.left),heightHelper(root.right));
        return height;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
