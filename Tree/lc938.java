package Tree;

public class lc938 {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum=0;
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode node,int low,int high){
        if (node==null){
            return;
        }
        if (node.val>=low && node.val<=high){
            sum+= node.val;
        }
        dfs(node.left, low, high);
        dfs(node.right, low, high);
    }
}
