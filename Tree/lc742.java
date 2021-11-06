package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class lc742 {
    public int findClosestLeaf(TreeNode root, int k) {
        TreeNode kNode=search(root, k);
        
        return 0;
    }

    private TreeNode search(TreeNode node, int k){
        if (node==null){
            return null;
        }
        if (node.val==k){
            return node;
        }
        if (search(node.left, k)!=null){
            return search(node.left, k);
        }
        else {
            return search(node.right, k);
        }
    }
}
