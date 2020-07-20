package Tree;

public class lc236 {
    /**
     * 本质上是dfs 判断左右子树是否存在p q node
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)return root;
        if (root.val==p.val||root.val==q.val){
            return root;
        }

        TreeNode lNode=helper(root.left, p, q);
        TreeNode rNode=helper(root.right, p, q);
        if (lNode!=null&&rNode!=null)return root;
        else if (lNode!=null)return lNode;
        else if (rNode!=null)return rNode;
        else return null;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
