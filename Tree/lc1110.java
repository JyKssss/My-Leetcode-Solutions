package Tree;

import java.util.*;

public class lc1110 {
    /**
     * 层序遍历找出被删节点和他的父节点
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode>deleteNodes=new ArrayList<>();
        List<TreeNode>fathers=new ArrayList<>();
        List<TreeNode>res=new ArrayList<>();
        Deque<TreeNode>line=new LinkedList<>();
        HashSet<Integer>toDelete=new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            toDelete.add(to_delete[i]);
        }
//        System.out.println(toDelete.size());
        TreeNode cur=root;
        if (toDelete.contains(cur.val)){
            deleteNodes.add(cur);
            fathers.add(null);
        }
        else res.add(cur);
        line.addLast(cur);
        int size;
        while (!line.isEmpty()){
            size=line.size();
            for (int i = 0; i < size; i++) {
                cur=line.pollFirst();
                if (cur.left!=null){
                    line.addLast(cur.left);
                    if (toDelete.contains(cur.left.val)){
                        deleteNodes.add(cur.left);
                        fathers.add(cur);
                    }
                }
                if (cur.right!=null){
                    line.addLast(cur.right);
                    if (toDelete.contains(cur.right.val)){
//                        System.out.println(cur.right.val);
                        deleteNodes.add(cur.right);
                        fathers.add(cur);
                    }
                }
            }
        }

        for (int i = 0; i < deleteNodes.size(); i++) {
            TreeNode father=fathers.get(i);
            TreeNode delete=deleteNodes.get(i);
            if (father!=null){
                if (father.left==delete){
                    father.left=null;
                }
                else if (father.right==delete){
                    father.right=null;
                }
            }
            if (delete.left!=null&&!toDelete.contains(delete.left.val)){
                res.add(delete.left);
            }
            if (delete.right!=null&&!toDelete.contains(delete.right.val)){
                res.add(delete.right);
            }

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
