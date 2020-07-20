package Tree;

import java.util.*;

/**
 * 与层序遍历相似 中间用栈倒置数据
 * 可以用Collections.reverse来翻转
 */
public class lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        Queue<TreeNode> line=new LinkedList<>();
        Stack<Integer> reverse=new Stack<>();
        int i=0;
        line.add(root);
        while (!line.isEmpty()){
            List<Integer> lineVal=new ArrayList<>();
            int length=line.size();
            i++;
            for (int j = 0; j < length; j++) {
                TreeNode node=line.poll();
                if (node==null)continue;
                lineVal.add(node.val);
//                if (i%2==1)lineVal.add(node.val);
//                if (i%2==0)reverse.push(node.val);
                line.add(node.left);
                line.add(node.right);

            }
            if (i%2==0){
//                while (!reverse.isEmpty()){
//                    int resVal=reverse.pop();
//                    lineVal.add(resVal);
//                }
                Collections.reverse(lineVal);
            }

            if (lineVal.size()==0)break;
            res.add(lineVal);
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
