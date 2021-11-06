package Tree;

public class lc250 {
    int cnt;
    public int countUnivalSubtrees(TreeNode root) {
        cnt = 0;
        if (root == null){
            return cnt;
        }
        int val = root.val;
        helper(root, -1001);
        return cnt;
    }

    private boolean helper(TreeNode node, int val){
        if (node == null){
            return true;
        }

        boolean leftB = helper(node.left, node.val), rightB = helper(node.right, node.val);
        if (leftB && rightB){
            cnt += 1;
            return node.val == val;
        }
        return false;
    }
}
