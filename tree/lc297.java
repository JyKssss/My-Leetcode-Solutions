package tree;


import java.util.*;

public class lc297 {
    /**
     * String是object 不能用==
     * 思路 层序遍历 但要保存null节点来维持树的形状
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
//        String res=new String();
        StringBuffer stringBuffer=new StringBuffer();
        if(root==null){
            return stringBuffer.append("null,").toString();
//            return res+"null,";
        }
        Deque<TreeNode>line=new LinkedList<>();
        line.addLast(root);
        while (!line.isEmpty()){
            int length=line.size();
            for (int i = 0; i < length; i++) {
                TreeNode cur=line.pollFirst();
                if (cur==null){
                    stringBuffer.append("null,");
//                    res=res+"null,";
                    continue;
                }
                stringBuffer.append(cur.val).append(",");
//                res=res+cur.val+",";
                line.addLast(cur.left);
                line.addLast(cur.right);
            }

        }
//        System.out.println(res);
        return stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))return null;
        String[] strings=data.split(",");
        Deque<String> nodeString=new LinkedList<>(Arrays.asList(strings));
        Deque<TreeNode> line=new LinkedList<>();
        if (nodeString.peekFirst().equals("null"))return null;
        TreeNode root=new TreeNode(Integer.valueOf(nodeString.pollFirst()));
        line.addLast(root);
        while (!nodeString.isEmpty()){
            int length=line.size();
            for (int i = 0; i < length; i++) {
                TreeNode node=line.pollFirst();
                String leftstr=nodeString.pollFirst();
                String rightstr=nodeString.pollFirst();
                if (leftstr.equals("null"))node.left=null;
                else {
                    TreeNode left=new TreeNode(Integer.valueOf(leftstr));
                    node.left=left;
                    line.addLast(left);
                }
                if (rightstr.equals("null"))node.right=null;
                else {
                    TreeNode right=new TreeNode(Integer.valueOf(rightstr));
                    node.right=right;
                    line.addLast(right);
                }
            }


        }
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
