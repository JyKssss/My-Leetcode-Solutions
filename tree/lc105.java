package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lc105 {
    public static void main(String[] args) {
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        lc105 l=new lc105();
//        l.buildTree(pre, in);
        l.buildTreeIndex(pre, 0, pre.length-1, in, 0, in.length-1);
        
    }

    /**
     * 先序遍历 第一节点是中根 左子树随其后 最后是右子树
     * 根据中根在中序遍历中找到左子树和右子树  并据此在先序遍历中找到对应的左右子树迭代
     * 优化 ：可以不用复制数组的方式 转而使用角标index 大幅降低内存开销
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        int val=preorder[0];
        TreeNode root=new TreeNode(val);
        int i=0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i]==val)break;
        }
        if (i>0){
            int[] leftInorder=new int[i];
            System.arraycopy(inorder, 0, leftInorder, 0, i);
            int[] leftPre=new int[i];
            System.arraycopy(preorder, 1, leftPre, 0, i);
            root.left=buildTree(leftPre,leftInorder);
        }
        else root.left=null;
        if (i<inorder.length-1){
            int[] rightInorder=new int[inorder.length-i-1];
            System.arraycopy(inorder, i+1, rightInorder, 0, inorder.length-i-1);
            int[] rightPre=new int[inorder.length-i-1];
            System.arraycopy(preorder, i+1, rightPre, 0, inorder.length-i-1);
            root.right=buildTree(rightPre,rightInorder);
        }
        else root.right=null;
        return root;
    }

    public TreeNode buildTreeIndex(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd ){
        if (preEnd-preStart<0)return null;
        int val=preorder[preStart];
        TreeNode root=new TreeNode(val);
        int i=inStart;
        for(i=inStart;i<=inEnd;i++){
            if (inorder[i]==val)break;
        }
        if (i>inStart){
            root.left=buildTreeIndex(preorder, preStart+1, preStart+i-inStart, inorder, inStart, i-1);
        }
        else root.left=null;
        if (i<inEnd){
            root.right=buildTreeIndex(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
        }
        else root.right=null;
        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
