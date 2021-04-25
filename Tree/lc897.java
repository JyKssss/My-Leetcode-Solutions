package Tree;


import java.util.Deque;
import java.util.LinkedList;

public class lc897 {
    /**
     * 迭代解法
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode cur=root,prev=new TreeNode(),head;
        Deque<TreeNode>list=new LinkedList<>();
        while (cur!=null){
            list.addFirst(cur);
            cur=cur.left;
        }
        head=list.getFirst();
        while (!list.isEmpty()){
            cur=list.pollFirst();
            prev.right=cur;
            cur.left=null;
            prev=cur;
            if (cur.right!=null){
                cur=cur.right;
                while (cur!=null){
                    list.addFirst(cur);
                    cur=cur.left;
                }
            }

        }
        return head;
    }


    /**
     * 递归解法
     * @param root
     * @return
     */
    TreeNode prevNode;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummy=new TreeNode();
        prevNode=dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode node){
        if (node==null){
            return;
        }

        inOrder(node.left);
        prevNode.right=node;
        node.left=null;
        prevNode=node;
        inOrder(node.right);
    }
}
