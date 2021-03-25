package Tree;

public class lc426 {
    TreeNode head;
    public TreeNode Convert(TreeNode pRootOfTree){
        TreeNode lastNode=null;
        inOrder(lastNode, pRootOfTree);
        return head;
    }

    private TreeNode inOrder(TreeNode lastNode, TreeNode root){
        if (root==null){
            return null;
        }
        if (root.left!=null){
            lastNode=inOrder(lastNode, root.left);
        }
        root.left=lastNode;
        if (lastNode!=null){
            lastNode.right=root;
        }
        lastNode=root;
        if (root.right!=null){
            lastNode=inOrder(lastNode, root.right);
        }
        if (head==null){
            head=root;
        }
        return lastNode;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
