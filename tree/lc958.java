package tree;

import java.util.Deque;
import java.util.LinkedList;

public class lc958 {
    /**
     * 层序遍历
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode>line=new LinkedList<>();
        boolean meetNull=false;

        TreeNode cur=root;
        line.addLast(cur);
        int size;
        while (!line.isEmpty()){
            size=line.size();
            for (int i = 0; i < size; i++) {
                cur=line.pollFirst();
                if (meetNull==false){
                    if (cur!=null){
                        line.addLast(cur.left);
                        line.addLast(cur.right);
                    }
                    else {
                        meetNull=true;
                    }
                }
                else {
                    if (cur!=null){
                        return false;
                    }
                    else {
                    }
                }
            }
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
