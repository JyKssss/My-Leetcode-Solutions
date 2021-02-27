package Tree;

public class lc998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root==null||val>root.val){
            TreeNode node=new TreeNode(val, root, null);
            return node;
        }
        else if (val< root.val){
            root.right=insertIntoMaxTree(root.right, val);
        }
        return root;
    }

    public class TreeNode {
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
