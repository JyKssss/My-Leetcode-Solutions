package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>res=new ArrayList<>();
        Deque<Integer> soloRes=new LinkedList<>();
        pathHelper(root, sum, soloRes, res);
        return res;
    }
    public void pathHelper(TreeNode root, int sum, Deque<Integer>solo, List<List<Integer>>res){
        if (root==null)return;
        sum-=root.val;
        solo.addLast(root.val);

        if (sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(solo));
            solo.removeLast();
            return;
        }
        pathHelper(root.left, sum, solo, res);
        pathHelper(root.right, sum, solo, res);
        solo.removeLast();
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
