package Tree;

public class lc337 {
    /**
     * 两类情况 选当前节点和不选当前节点
     * 1 选当前节点
     * f=g(left)+g(right)
     * 2 不选择当前节点
     * f=max(g(left),f(left))+max(g(right),f(right))
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int [] results=dfs(root);
        return Math.max(results[0],results[1]);
    }

    public int[] dfs(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        int selected=root.val+left[0]+right[0];
        int notSelected=Math.max(left[0],left[1])+Math.max(right[0], right[1]);
        return new int[]{notSelected,selected};
    }

    private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
