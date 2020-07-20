package Tree;


import java.util.*;

/**
 * 广度优先搜索
 */
public class lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res =new ArrayList<>();
        Queue<TreeNode> layer =new LinkedList<>();
        layer.add(root);
        while (!layer.isEmpty()){
            List<Integer>layerVal =new ArrayList<>();
            int length=layer.size();
            for (int i = 0; i < length; i++) {
                TreeNode tn =layer.poll();
                if (tn!=null){
                    layerVal.add(tn.val);
                    layer.add(tn.left);
                    layer.add(tn.right);
                }
            }
            if (layerVal.size()==0)break;

            res.add(layerVal);
//            layerVal.clear();
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
