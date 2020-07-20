package Tree;

import java.util.ArrayList;
import java.util.List;

public class lc230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>res=new ArrayList<>();
        inOrderHelper(root, res);
        return res.get(k-1);
    }
    public void inOrderHelper(TreeNode root, List<Integer>inRes){
        if (root==null)return;
        inOrderHelper(root.left, inRes);
        inRes.add(root.val);
        inOrderHelper(root.right, inRes);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
