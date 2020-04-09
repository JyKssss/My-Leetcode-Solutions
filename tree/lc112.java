package tree;

public class lc112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)return false;
        sum-=root.val;
        if (root.left==null&&root.right==null){
            return sum==0;
        }
        else {
            if (root.left!=null&&root.right!=null){
                return (hasPathSum(root.left, sum)||hasPathSum(root.right, sum));
            }
            else if (root.left!=null){
                return  hasPathSum(root.left, sum);
            }
            else if (root.right!=null){
                return  hasPathSum(root.right, sum);
            }
            else return false;
        }
    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
