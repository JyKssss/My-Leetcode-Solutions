package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder=new ArrayList<>();
        List<Pair<TreeNode,TreeNode>>reverse=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode tmp=root;
        while (tmp!=null||!stack.isEmpty()){
            while (tmp!=null){
                stack.push(tmp);
                tmp=tmp.left;
            }
            tmp=stack.pop();
            inorder.add(tmp);
            tmp=tmp.right;
        }
        TreeNode pre=null;
        for (TreeNode cur:inorder){
            if (pre==null){
                pre=cur;
                continue;
            }
            else {
                if (pre.val<=cur.val){
                    pre=cur;
                    continue;
                }
                else {
                    reverse.add(new Pair<>(pre, cur));
                    pre=cur;
                }
            }
        }
        if (reverse.size()==1){
            int inter=reverse.get(0).getKey().val;
            reverse.get(0).getKey().val=reverse.get(0).getValue().val;
            reverse.get(0).getValue().val=inter;
        }
        else if (reverse.size()==2){
            int inter=reverse.get(0).getKey().val;
            reverse.get(0).getKey().val=reverse.get(1).getValue().val;
            reverse.get(1).getValue().val=inter;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
