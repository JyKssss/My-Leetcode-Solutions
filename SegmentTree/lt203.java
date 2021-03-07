package SegmentTree;

public class lt203 {
    /**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.start== root.end && root.start==index){
            root.max=value;
            return;
        }
        int mid= root.start+ (root.end- root.start)/2;
        if (index<=mid){
            modify(root.left, index, value);
            root.max=Math.max(root.left.max, root.right.max);
        }
        else {
            modify(root.right, index, value);
            root.max=Math.max(root.left.max, root.right.max);
        }
        return;
    }



    class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
}
