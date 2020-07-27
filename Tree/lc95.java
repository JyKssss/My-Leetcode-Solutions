package Tree;

import com.sun.org.apache.bcel.internal.generic.RET;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<Pair<Integer,Integer>,List<TreeNode>>memeoryMap=new HashMap<>();
        if (n==0)return res;
//        return generateTrees(1, n);
        return generateWithMemory(1, n, memeoryMap);
    }


    /**
     * 递归 i为根节点 分别递归左子树和右子树
     * @param start
     * @param end
     * @return
     */
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> allNodes=new ArrayList<>();
        if (start>end){
            allNodes.add(null);
            return allNodes;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode>leftNodes=generateTrees(start,i-1);
            List<TreeNode>rightNodes=generateTrees(i+1, end);

            for(TreeNode left:leftNodes){
                for(TreeNode right:rightNodes){
                    TreeNode root=new TreeNode(i, left, right);
                    allNodes.add(root);
                }
            }
        }
        return allNodes;
        
    }

    /**
     * 记忆化递归
     * @param start
     * @param end
     * @param memoryMap
     * @return
     */
    public List<TreeNode> generateWithMemory(int start,int end,HashMap<Pair<Integer,Integer>,List<TreeNode>>memoryMap){
        List<TreeNode>allNodes=new ArrayList<>();
        if (start>end){
            allNodes.add(null);
            return allNodes;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode>leftnodes=new ArrayList<>(),rightnodes=new ArrayList<>();
            if (memoryMap.containsKey(new Pair<>(start, i-1))) leftnodes=memoryMap.get(new Pair<>(start, i-1));
            else leftnodes=generateWithMemory(start, i-1,memoryMap);
            if (memoryMap.containsKey(new Pair<>(i+1, end))) rightnodes=memoryMap.get(new Pair<>(i+1, end));
            else rightnodes=generateWithMemory(i+1,end,memoryMap);

            for(TreeNode left:leftnodes) {
                for (TreeNode right : rightnodes) {
                    TreeNode root=new TreeNode(i, left, right);
                    allNodes.add(root);
                }
            }
        }
        memoryMap.put(new Pair<>(start, end), allNodes);
        return allNodes;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
