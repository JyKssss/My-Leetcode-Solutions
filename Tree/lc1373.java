package Tree;

/***
 * 深度搜索遍历所有节点 同时判断子树是否是bst
 */
public class lc1373 {
    int globalMax=0;

    private Result dfs(TreeNode root){
        if (root==null){
            return null;
        }
        Result leftRes=dfs(root.left);
        Result rightRes=dfs(root.right);
        int resMin=root.val;
        int resMax=root.val;
        int resSum=root.val;
        boolean isBst=true;

        if (leftRes!=null){
            resSum+=leftRes.sumValue;
            resMin=Math.min(leftRes.min, resMin);
            resMax=Math.max(leftRes.max, resMax);
            isBst=root.val>leftRes.max && leftRes.isBst;
        }
        if (rightRes!=null){
            resSum+=rightRes.sumValue;
            resMin=Math.min(rightRes.min,resMin);
            resMax=Math.max(rightRes.max, resMax);
            isBst=root.val<rightRes.min && rightRes.isBst && isBst;
        }

        if (isBst){
            globalMax=Math.max(resSum, globalMax);
        }
        return new Result(resMin, resMax, resSum, isBst);

    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return globalMax;
    }

}



class Result{
    int min;
    int max;
    int sumValue;
    boolean isBst;

    public Result(int min, int max, int sumValue, boolean isBst) {
        this.min = min;
        this.max = max;
        this.sumValue = sumValue;
        this.isBst = isBst;
    }
}



