package Tree;

public class lc968 {
    //每个节点一共三种状态
    // 0:未被覆盖 1:安装了监视器 2:未安装监视器但被覆盖
    //后续遍历 先到叶子结点
    int total=0;
    public int minCameraCover(TreeNode root) {
        if (root==null)return 0;
        if (dfs(root)==0)total++;
        return total;
    }

    public int dfs(TreeNode node){
        if (node==null)return 2;
        int l=dfs(node.left),r=dfs(node.right);
        if (l==0||r==0){
            total++;
            return 1;
        }
        if (l==1||r==1)return 2;
        return 0;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
