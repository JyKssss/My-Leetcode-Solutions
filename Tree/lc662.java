package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class lc662 {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Deque<Node> layer = new LinkedList<>();
        layer.addLast(new Node(root, 0));
        while (layer.size() > 0) {
            int size = layer.size();
            long width = layer.getLast().rank - layer.getFirst().rank + 1;
            for (int i = 0; i < size; i++) {
                Node curNode = layer.pollFirst();
                if (curNode.node.left != null) {
                    layer.addLast(new Node(curNode.node.left, curNode.rank * 2));
                }
                if (curNode.node.right != null) {
                    layer.addLast(new Node(curNode.node.right, curNode.rank * 2 + 1));
                }
            }
            maxWidth = (int) Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    private class Node {
        TreeNode node;
        long rank;

        public Node(TreeNode node, long rank) {
            this.node = node;
            this.rank = rank;
        }
    }
}
