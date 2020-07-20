package Tree;

import java.util.Stack;

public class lc173 {
    /**
     * 把循环中序遍历二叉树的代码拆开
     */
    class BSTIterator {
        Stack<TreeNode>stack;
        public BSTIterator(TreeNode root) {
            this.stack=new Stack<>();
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node =stack.pop();
            int val=node.val;
            if (node.right!=null){
                node=node.right;
                while (node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
            return val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (stack.isEmpty())return false;
            return true;
        }

        private class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    }
}
