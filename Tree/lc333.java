package Tree;

public class lc333 {
    int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recurse(root);
        return maxSize;
    }

    private int[] recurse(TreeNode node) {
        //{smallest, largest, isBST, size}
        if (node.left == null && node.right == null) {
            maxSize = Math.max(1, maxSize);
            return new int[]{node.val, node.val, 1, 1};
        }
        int[] left = null, right = null;
        int largest = node.val, smallest = node.val;
        int size = 1;
        if (node.left != null) {
            left = recurse(node.left);
            largest = Math.max(largest, left[1]);
            smallest = Math.min(smallest, left[0]);
            size += left[3];
        }
        if (node.right != null) {
            right = recurse(node.right);
            largest = Math.max(largest, right[1]);
            smallest = Math.min(smallest, right[0]);
            size += right[3];
        }
        boolean isBST = true;
        if (left != null && left[2] == 0) {
            isBST = false;
        }
        if (right != null && right[2] == 0) {
            isBST = false;
        }
        if (left != null && left[1] >= node.val) {
            isBST = false;
        }
        if (right != null && right[0] <= node.val) {
            isBST = false;
        }

        if (isBST) {
            maxSize = Math.max(maxSize, size);
        }
        return new int[]{smallest, largest, isBST ? 1 : 0, size};
    }
}
