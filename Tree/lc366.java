package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, List<List<Integer>> res) {
        int height;
        if (node.right == null && node.left == null) {
            height = 0;

        } else if (node.left == null) {
            height = dfs(node.right, res) + 1;
        } else if (node.right == null) {
            height = dfs(node.left, res) + 1;
        } else {
            height = Math.max(dfs(node.right, res), dfs(node.left, res)) + 1;
        }

        if (res.size() <= height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);

        return height;
     }
}
