package Tree;

public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null)return new TreeNode(val);
        else if (root.val>val)root.left= insertIntoBST(root.left,val);
        else root.right= insertIntoBST(root.right,val);
        return root;
    }
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root==null)return new TreeNode(val);
        TreeNode p=root,q;
        while (p!=null){
            if (p.val>val){
                if (p.left!=null)p=p.left;
                else {
                    p.left=new TreeNode(val);
                    break;
                }
            }
            else {
                if (p.right!=null)p=p.right;
                else {
                    p.right=new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
