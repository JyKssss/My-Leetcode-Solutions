package tree;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helperPre(root, res);
        return res;
    }

    /**
     * 递归前序遍历
     * @param root
     * @param res
     */
    public void helperPre(TreeNode root, List<Integer>res){
        if (root==null)return;
        res.add(root.val);
        helperPre(root.left, res);
        helperPre(root.right, res);
    }

    /**
     * 循环前序遍历
     * @param root
     * @return
     */
    public List<Integer> helperPreLoop(TreeNode root){
        if (root==null)return null;
        Stack<TreeNode>tmpStack=new Stack<>();
        List<Integer>res= new ArrayList<>();
        tmpStack.push(root);
        while (!tmpStack.isEmpty()){
            TreeNode node=tmpStack.pop();
            res.add(node.val);
            if (node.right!=null)tmpStack.push(node.right);
            if (node.left!=null)tmpStack.push(node.left);
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
