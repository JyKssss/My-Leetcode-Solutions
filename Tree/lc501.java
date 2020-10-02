package Tree;

import java.util.ArrayList;
import java.util.List;

public class lc501 {
    int preVal,curTimes,largestNum;
    List<Integer>res;
    public int[] findMode(TreeNode root) {
        largestNum=0;
        res=new ArrayList<>();
        dfs(root);
        int[] r=new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]=res.get(i);
        }
        return r;
    }
    public void dfs(TreeNode node){
        if (node==null)return;
        dfs(node.left);
        if (preVal== node.val){
            curTimes++;
        }
        else {
            preVal=node.val;
            curTimes=1;
        }

        if (curTimes==largestNum){
            res.add(node.val);
        }
        else if (curTimes>largestNum){
            largestNum=curTimes;
            res.clear();
            res.add(node.val);
        }
        dfs(node.right);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
