package tree;

/**
 * 翻转二叉树 自顶向下的翻转
 */
public class lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;

        //交换左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
  }
}
