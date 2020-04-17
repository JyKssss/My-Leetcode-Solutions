package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 得到先序遍历的序列后
 */
public class lc114 {
    public void flatten(TreeNode root) {
        List<TreeNode>pre =new ArrayList<>();
        preOrder(root,pre);
        for (int i = 0; i < pre.size(); i++) {
            if (i==pre.size()-1){
                TreeNode node=pre.get(i);
                node.right=null;
                node.left=null;
                break;
            }
            TreeNode node=pre.get(i);
            node.left=null;
            node.right=pre.get(i+1);
        }
    }
    public void preOrder(TreeNode root,List<TreeNode>order){
        if (root==null)return;
        order.add(root);
        preOrder(root.left, order);
        preOrder(root.right, order);
    }

    /**
     * 把左右子树捋直 右子树接到左子树末尾
     * @param root
     */
    public void flatten2(TreeNode root){
        if (root==null)return;
        TreeNode tmp=root.right;
        flatten2(root.left);
        flatten2(root.right);
        root.right=root.left;
        root.left=null;
        while (root.right!=null){
            root=root.right;
        }
        root.right=tmp;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
