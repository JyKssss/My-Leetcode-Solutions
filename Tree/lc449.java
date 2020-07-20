package Tree;


import java.util.*;

public class lc449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String preString=new String();
        if (root==null)return preString;
        List<Integer>preOrder=new ArrayList<>();
        preOrder(root,preOrder);
        for(Integer val:preOrder){
            preString=preString+String.valueOf(val)+",";
        }
        return preString;
    }
    public void preOrder(TreeNode root,List<Integer>preList){
        if (root==null)return;
        Stack<TreeNode>stack =new Stack<>();
        TreeNode cur=root;
        stack.push(cur);
        while (!stack.isEmpty()){
            cur=stack.pop();
            preList.add(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preStrings=data.split(",");
        if (preStrings.length==0)return null;
        List<Integer>preOrder=new ArrayList<>();
        for (int i = 0; i < preStrings.length; i++) {
            preOrder.add(Integer.valueOf(preStrings[i]));
        }
        List<Integer>inOrder=new ArrayList<>(preOrder);
//        Collections.sort(inOrder);
        inOrder.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return buildBST(preOrder, 0, preOrder.size()-1, inOrder, 0, inOrder.size()-1);
    }

    public TreeNode buildBST(List<Integer>preOrder,int preStart,int preEnd,List<Integer>inOrder,int inStart,int inEnd){
        if (preEnd-preStart<0)return null;
        if (preEnd-preStart==0)return new TreeNode(preOrder.get(preStart));
        int rootVal=preOrder.get(preStart);
        int rootIndex;
        for (rootIndex = inStart; rootIndex <=inEnd ; rootIndex++) {
            if (inOrder.get(rootIndex)==rootVal)break;
        }
        TreeNode root=new TreeNode(rootVal);
        root.left=buildBST(preOrder, preStart+1,preStart+rootIndex-inStart , inOrder, inStart, rootIndex-1);
        root.right=buildBST(preOrder, preStart+rootIndex-inStart+1, preEnd, inOrder, rootIndex+1, inEnd);
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
