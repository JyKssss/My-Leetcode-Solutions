package Tree;

/**
 * 递归解平衡二叉树
 * 1 递归的终止条件
 * 2 应当返回什么
 * 3 每一层的操作
 * 把递归拆解到每一层思考
 */


public class lc110 {
    public boolean isBalanced(TreeNode root) {
        return isBST(root).isBst;
    }
    public ReturnNode isBST(TreeNode root){
        if (root==null){
            return new ReturnNode(true,0);
        }
        ReturnNode left =isBST(root.left);
        ReturnNode right=isBST(root.right);
        if (left.isBst&&right.isBst&&Math.abs(left.height-right.height)<=1){
            return new ReturnNode(true, Math.max(left.height, right.height));
        }
        else {
            return new ReturnNode(false, Math.max(left.height, right.height));
        }

    }

    private class ReturnNode{
        boolean isBst;
        int height;
        public ReturnNode(boolean isBst, int height) {
            this.isBst = isBst;
            this.height = height;
        }
    }

    private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

}
