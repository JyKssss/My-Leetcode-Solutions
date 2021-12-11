package Tree;

import javafx.util.Pair;

import java.util.*;

public class lc314 {
    // Layer Traverse
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, List<Integer>> layerTreeMap = new TreeMap<>();
        Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        deque.addLast(new Pair<>(root, 0));
        while (deque.size() > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> nodePair = deque.pollFirst();
                int layer = nodePair.getValue();
                TreeNode node = nodePair.getKey();
                if (node.left != null) {
                    deque.addLast(new Pair<>(node.left, layer - 1));
                }
                if (node.right != null) {
                    deque.addLast(new Pair<>(node.right, layer + 1));
                }
                layerTreeMap.putIfAbsent(layer, new ArrayList<>());
                List<Integer> layerList = layerTreeMap.get(layer);
                layerList.add(node.val);
            }
        }

        while (!layerTreeMap.isEmpty()) {
            res.add(layerTreeMap.pollFirstEntry().getValue());
        }
        return res;
    }
}
