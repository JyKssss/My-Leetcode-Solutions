package Tree;


public class lc450 {
    /**
     * preNode来记住被删除节点的父节点 pre来记住被交换（pop up）节点的父节点
     */
    TreeNode preNode;
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode original=root;
        TreeNode target=findNode(root, key);
        if (target==null||target.val!=key)return original;
        TreeNode next=delete(target);
        if (preNode==null)return next;
        else {
            if (preNode.left!=null&&preNode.left.equals(target)){
                preNode.left=next;
            }
            else if (preNode.right!=null&&preNode.right.equals(target)){
                preNode.right=next;
            }
            return original;
        }
    }
    public TreeNode findNode(TreeNode root,int key){
        while (root!=null){
            if (key<root.val){
                preNode=root;
                root=root.left;
            }
            else if (key>root.val){
                preNode=root;
                root=root.right;
            }
            else return root;
        }
        return root;
    }
    public TreeNode delete(TreeNode target){
        if (target.left==null&&target.right==null)return null;
        else if (target.left==null)return target.right;
        else if (target.right==null)return target.left;
        else {
            TreeNode tmp=target.right;
            TreeNode pre=target;
            while (tmp.left!=null){
                pre=tmp;
                tmp=tmp.left;
            }
            //需判断pre是否就是target
            if (pre==target){
                tmp.left=pre.left;
                return tmp;
            }

            if (pre.left.equals(tmp))pre.left=tmp.right;
            else if (pre.right.equals(tmp))pre.right=null;
            tmp.left=target.left;
            tmp.right=target.right;
            return tmp;
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
