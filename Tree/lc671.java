package Tree;

public class lc671 {
    int least;
    public int findSecondMinimumValue(TreeNode root) {
        least= root.val;
        return dfs(root);
    }

    private int dfs(TreeNode node){
        if (node==null){
            return -1;
        }
        int l=dfs(node.left),r=dfs(node.right);
        if (l!=-1&&r!=-1){
            return Math.min(l, r);
        }
        else if (l!=-1){
            return l;
        }
        else if (r!=-1){
            return r;
        }
        else {
            if (node.val>least){
                return node.val;
            }
            else {
                return -1;
            }
        }
    }

}
