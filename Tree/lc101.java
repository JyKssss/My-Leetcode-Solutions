package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lc101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymRecurrence(root, root);
    }

    /**
     * 递归解法  判断左子树的左孩子与右子树的右孩子 以及左子树的右孩子与右子树的左孩子
     * @param t1
     * @param t2
     * @return
     */
    public static boolean isSymRecurrence(TreeNode t1,TreeNode t2){
        if (t1==null&&t2==null)return true;
        if (t1==null||t2==null)return false;

        return (t1.val==t2.val)&&(isSymRecurrence(t1.left,t2.right))&&(isSymRecurrence(t1.right,t2.left));
    }

    /**
     * 通过队列来层次遍历二叉树 相比较的节点放在一起
     * @param tree
     * @return
     */
    public static boolean isSymIteration(TreeNode tree){
        Queue<TreeNode> queue =new LinkedList<>();
        if (tree==null)return true;
        if (tree.left==null&&tree.right==null)return true;
        if (tree.left==null||tree.right==null)return false;
        queue.add(tree.left);
        queue.add(tree.right);
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            if (left==null&&right==null)continue;
            if (left==null||right==null)return false;
            if (left.val!=right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;

    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
