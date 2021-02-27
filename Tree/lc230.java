package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc230 {
    //空间复杂度较高
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



    //使用迭代遍历
    static int cnt=0;
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode>nodeLinkedList=new LinkedList<>();
        while (root!=null|| !nodeLinkedList.isEmpty()){
            while (root!=null){
                nodeLinkedList.push(root);
                root=root.left;
            }
            root=nodeLinkedList.pollFirst();
            cnt++;
            if (cnt==k){
                return root.val;
            }
            root=root.right;
        }
        return 0;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
