package tree;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class lc257 {
    List<String>res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null)return res;
        String path=String.valueOf(root.val);
        if (root.right!=null&&root.left!=null){
            helper(root.left, path);
            helper(root.right, path);
        }
        else if (root.left!=null){
            helper(root.left, path);
        }
        else if (root.right!=null){
            helper(root.right, path);
        }
        else res.add(path);
        return res;
    }
    public void helper(TreeNode root,String path){
        if (root==null)return;
        String addingPath =path+"->"+String.valueOf(root.val);
        if (root.left!=null&&root.right!=null){
            helper(root.left, addingPath);
            helper(root.right, addingPath);
        }
        else if (root.left!=null){
            helper(root.left, addingPath);
        }
        else if (root.right!=null){
            helper(root.right, addingPath);
        }
        else {
            res.add(addingPath);
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
