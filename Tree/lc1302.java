package Tree;

import java.util.HashMap;
import java.util.Map;

public class lc1302 {
    public int deepestLeavesSum(TreeNode root) {
        layerMap = new HashMap<>();
        dfs(layerMap, 1, root);
        return layerMap.get(maxHeight);
    }

    private void dfs(Map<Integer, Integer> layerMap, int layer, TreeNode node) {
        if (node != null) {
            maxHeight = Math.max(maxHeight, layer);
            layerMap.put(layer, layerMap.getOrDefault(layer, 0) + node.val);
            dfs(layerMap, layer + 1, node.left);
            dfs(layerMap, layer + 1, node.right);
        }
    }
    int maxHeight = 0;
    Map<Integer, Integer> layerMap;
}
