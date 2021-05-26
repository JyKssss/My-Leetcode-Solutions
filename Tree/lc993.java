package Tree;

public class lc993 {
    int fatherX,fatherY,depthX,depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y, 0);
        return depthY == depthX && fatherX != fatherY;
    }

    private void dfs(TreeNode node, int father,int x, int y, int depth){
        if (node==null){
            return;
        }
        if (node.val==x){
            fatherX=father;
            depthX=depth;
        }
        else if (node.val==y){
            fatherY=father;
            depthY=depth;
        }
        dfs(node.left, node.val, x, y,depth+1);
        dfs(node.right, node.val, x, y,depth+1);
    }
}
