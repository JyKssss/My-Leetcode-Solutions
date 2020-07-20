package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历 递归算法遍历 和 栈遍历
 */
public class lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<Integer>();
        solve(root, res);
        return res;

    }
    private void solve(TreeNode cur, List<Integer>res){
        if (cur==null)return;
        solve(cur.left, res);
        res.add(cur.val);
        solve(cur.right, res);
    }

    public List<Integer> inorderStack(TreeNode root){
        List<Integer>res=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
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
