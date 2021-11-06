package Tree;

import java.util.HashMap;
import java.util.HashSet;

public class lc437 {
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        HashMap<Long,Integer> valMap = new HashMap<>();
        valMap.put((long) 0, 1);
        if (root == null){
            return 0;
        }
        dfs(root, targetSum, 0, valMap);
        return count;
    }

    private void dfs(TreeNode node, int targetSum, long curSum, HashMap<Long, Integer> map){
        curSum += node.val;
        count += map.getOrDefault(curSum-targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        if (node.left != null){
            dfs(node.left, targetSum, curSum, map);
        }
        if (node.right != null){
            dfs(node.right, targetSum, curSum, map);
        }
        if (map.get(curSum) > 1){
            map.put(curSum, map.get(curSum)-1);
        }
        else {
            map.remove(curSum);
        }
        curSum -= node.val;
    }
}
