package SegmentTree;

public class lt439 {
    /**
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        int start=0,end=A.length-1;
        return buildHelper(A, start, end);
    }

    public SegmentTreeNode buildHelper(int[] A, int start, int end){
        if (start>end){
            return null;
        }
        if (start==end){
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid=start+(end-start)/2;
        SegmentTreeNode left =buildHelper(A, start, mid), right=buildHelper(A, mid+1, end);
        SegmentTreeNode node=new  SegmentTreeNode(start,end,Math.max(left.max, right.max));
        node.left=left;
        node.right=right;

        return node;
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



