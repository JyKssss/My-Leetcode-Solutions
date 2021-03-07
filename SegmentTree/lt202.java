package SegmentTree;

public class lt202 {
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        int rStart=root.start,rEnd= root.end;
        if (start==rStart && rEnd==end){
            return root.max;
        }
        else{
            int rMid=rStart+(rEnd-rStart)/2;
            int leftMax=Integer.MIN_VALUE,rightMax=Integer.MIN_VALUE;
            if (start<=rMid){
                if (end>rMid){
                    leftMax=query(root.left, start, rMid);
                }
                else {
                    leftMax=query(root.left, start, end);
                }
            }

            if (end>rMid){
                if (start<=rMid){
                    rightMax=query(root.right, rMid+1, end);
                }
                else {
                    rightMax=query(root.right, start, end);
                }
            }
            return Math.max(leftMax, rightMax);
        }
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
