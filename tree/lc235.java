package tree;

public class lc235 {
    /**
     * 利用二叉树的性质 p q两节点如果在一个二叉树的两个子树则root就是答案
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root,TreeNode p,TreeNode q){
        if (((p.val>root.val)&&(q.val<root.val))||((p.val<root.val)&&(q.val>root.val)))return root;
        else if (p.val==root.val||q.val==root.val)return root;
        else if (p.val<root.val&&q.val<root.val)return helper(root.left, p, q);
        else return helper(root.right, p, q);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
