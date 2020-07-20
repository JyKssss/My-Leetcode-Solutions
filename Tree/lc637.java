package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc637 {
    /**
     * 层序遍历就完事了
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>res=new ArrayList<>();
        if (root==null)return res;
        Deque<TreeNode>line=new LinkedList<>();
        TreeNode cur=root;
        line.addLast(cur);
        while (!line.isEmpty()){
            int size=line.size();
            double total=0;
            for (int i = 0; i < size; i++) {
                cur=line.pollFirst();
                total+=cur.val;
                if (cur.left!=null){
                    line.addLast(cur.left);
                }
                if (cur.right!=null){
                    line.addLast(cur.right);
                }
            }
            res.add(total/size);
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
