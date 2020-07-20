package Tree;

public class lc222 {
    /**
     * 二分法巧妙思想  递归判断左右子树高度 相等表示左子树是满二叉树 计算右子树节点 不相等表示右子树是高度-1的满二叉树
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root==null)return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if (leftHeight==rightHeight){
            return (1<<leftHeight)+countNodes(root.right);
        }
        else {
            return countNodes(root.left)+(1<<rightHeight);
        }
    }
    public int height(TreeNode root){
        int height=0;
        while (root!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
