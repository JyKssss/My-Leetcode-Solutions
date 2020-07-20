package Tree;

public class lc572 {
    /**
     * 思路BFS s树逐层匹配t树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s==null)return false;
        System.out.println("1");
        return helper(s, t)||isSubtree(s.left, t.left)||isSubtree(s.right, t.right);
    }
    public boolean helper(TreeNode s,TreeNode t){
        if (s==null||t==null){
            if (s==null&&t==null)return true;
            else return false;
        }
        if (s.val==t.val){
            return helper(s.left, t.left)&&helper(s.right,t.right);
        }
        else return false;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
