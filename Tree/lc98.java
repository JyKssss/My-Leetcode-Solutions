package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc98 {
    public boolean isValidBST(TreeNode root) {
        return verifyRecur(root, null, null);
    }

    /**
     * 递归判断 每一段传入的值是每节点的上界和下界
     * @param root
     * @param upper
     * @param lower
     * @return
     */
    public boolean verifyRecur(TreeNode root, Integer upper,Integer lower){
        if (root==null)return true;
        int val=root.val;

        if (upper!=null&&val>=upper)return false;
        if (lower!=null&&val<=lower)return false;

        if (!(verifyRecur(root.left, val, lower)))return false;
        if(!verifyRecur(root.right, upper, val))return false;
        return true;
    }

    /**
     * 判断中序遍历后的序列是否严格递增
     * @param root
     * @return
     */
    public boolean verifyInorder(TreeNode root){
        List<TreeNode>inorder=inorder(root);
        long pre,cur;
        pre=Long.MIN_VALUE;
        for (TreeNode node:inorder) {
            cur=node.val;
            if (cur<=pre)return false;
            pre=cur;
        }
        return true;
    }

    public List<TreeNode> inorder(TreeNode root){
        List<TreeNode>res =new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.add(root);
                root=root.left;
            }
            TreeNode tmp= stack.pop();
            res.add(tmp);
            root=tmp.right;
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
