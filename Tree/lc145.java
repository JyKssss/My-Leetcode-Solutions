package tree;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res =new ArrayList<>();
        postRecurHelper(root, res);
        return res;
    }

    /**
     * 递归 前中后序遍历都是一个模板
     * @param root
     * @param res
     */
    public void postRecurHelper(TreeNode root,List<Integer>res){
        if (root==null)return;
        postRecurHelper(root.left, res);
        postRecurHelper(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代遍历  用一个last节点判断返回的是左子树还是右子树
     * @param root
     * @return
     */
    public List<Integer> postLoopHelper(TreeNode root){
        List<Integer>res=new ArrayList<>();
        if (root==null)return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode last=null;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode tmp=stack.peek();
            if (tmp.right!=null&&tmp.right!=last){
                root=tmp.right;
            }
            else {
                res.add(tmp.val);
                last=tmp;
                stack.pop();
            }

        }
        return res;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
