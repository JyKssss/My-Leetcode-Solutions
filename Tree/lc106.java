package Tree;

public class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildIndex(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    /**
     * 与前中序遍历构造二叉树思路想同 lc105
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
     */
    public TreeNode buildIndex(int[] inorder,int inStart,int inEnd, int[]postorder,int postStart,int postEnd){
        if (inEnd-inStart<0)return null;
        int val=postorder[postEnd];
        TreeNode root=new TreeNode(val);
        int i;
        for ( i = inStart; i <=inEnd ; i++) {
            if (inorder[i]==val)break;
        }
        if (i>inStart){
            root.left=buildIndex(inorder, inStart, i-1, postorder, postStart, postStart+i-inStart-1);
        }
        else root.left=null;
        if(i<inEnd){
            root.right=buildIndex(inorder, i+1, inEnd, postorder,postStart+i-inStart,postEnd-1);
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
