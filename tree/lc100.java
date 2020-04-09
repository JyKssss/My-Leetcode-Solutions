package tree;

import javax.lang.model.type.ErrorType;

public class lc100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null||q==null){
            return p==null&&q==null;
        }
        if (p.val!=q.val)return false;
        return (isSameTree(p.left, q.left))&&(isSameTree(p.right, q.right));
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
