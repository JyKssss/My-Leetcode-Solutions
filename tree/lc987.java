package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc987 {
    List<location>res =new ArrayList<>();

    /**
     * 先序遍历一遍所有节点标好坐标 排序之后输出
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>vt=new ArrayList<>();
        if (root==null)return vt;
        helper(0, 0, root);
        Collections.sort(res);
        int preX,curX;
        List<Integer>line=new ArrayList<>();
        preX=res.get(0).x;
        line.add(res.get(0).node.val);
        for (int i = 1; i < res.size(); i++) {
            curX=res.get(i).x;
            if (preX!=curX){
                vt.add(line);
                line=new ArrayList<>();
                line.add(res.get(i).node.val);
                preX=curX;
            }
            else {
                line.add(res.get(i).node.val);
            }
        }
        if (line.size()!=0){
            vt.add(line);
        }
        return vt;
    }
    public void helper(int x, int y, TreeNode root){
        res.add(new location(x, y, root));
        if (root.left!=null){
            helper(x-1, y-1, root.left);
        }
        if (root.right!=null) {
            helper(x + 1, y - 1, root.right);
        }
    }
    private class location implements Comparable{
        int x;
        int y;
        TreeNode node;

        public location(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }

        @Override
        public int compareTo(Object o) {
            location n= (location) o;
            if (x!=n.x){
                return x-n.x;
            }
            else {
                if (y==n.y){
                    return node.val-n.node.val;
                }
                else return n.y-y;
            }
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
