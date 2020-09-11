package Tree;

import java.util.*;

public class lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>line =new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if (root==null)return res;
        int size=0;
        queue.add(root);
        while (!queue.isEmpty()){
            size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                line.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            res.add(line);
            line=new ArrayList<>();
        }
        Collections.reverse(res);
        return res;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
