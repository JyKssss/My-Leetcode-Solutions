package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc199 {
    /**
     * 层序遍历 记录每一层最后一个
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if (root==null)return res;
        Deque<TreeNode>line=new LinkedList<>();
        line.addLast(root);
        int size;
        while (!line.isEmpty()){
            size=line.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=line.pollFirst();
                if (cur.left!=null)line.addLast(cur.left);
                if (cur.right!=null)line.addLast(cur.right);
                if (i==size-1)res.add(cur.val);
            }
        }
        return res;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
