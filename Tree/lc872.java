package Tree;

import java.util.ArrayList;
import java.util.List;

public class lc872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>leafList1=new ArrayList<>();
        List<Integer>leafList2=new ArrayList<>();
        inOrder(leafList1, root1);
        inOrder(leafList2, root2);
        return leafList1.equals(leafList2);
    }

    private void inOrder(List<Integer>leafList, TreeNode node){
        if (node==null){
            return;
        }
        else if (node.left==null && node.right==null){
            leafList.add(node.val);
        }
        else {
            inOrder(leafList, node.left);
            inOrder(leafList, node.right);
        }

    }
}
