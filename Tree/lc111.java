package Tree;

public class lc111 {
    /**
     * 递归
     * 注意左右子树只有一支存在的情况
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null)return 0;
        int height=1;
        int hleft=minDepth(root.left);
        int hright=minDepth(root.right);
        if (root.left!=null&&root.right!=null)return Math.min(hleft+height, hright+height);
        else if (root.left!=null)return hleft+height;
        else if (root.right!=null)return hright+height;
        return height;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
