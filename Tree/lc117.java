package Tree;

public class lc117 {
    public Node connect(Node root) {
        if (root==null)return root;
        Node leftMost=null;
        Node nextPre=null,nextCur=null,cur=null;
        leftMost=root;
        while (leftMost!=null){
            cur=leftMost;
            //找下一级的最左节点
            //不断循环连接下一级的节点
            boolean findLeft=false;
            //每一行的循环
            while (cur!=null){
                if (cur.left!=null||cur.right!=null){
                    if (findLeft==false){
                        if (cur.left!=null){
                            leftMost=cur.left;
                            findLeft=true;
                            nextPre=cur.left;
                            if (cur.right!=null){
                                cur.left.next=cur.right;
                                nextPre=cur.right;
                            }
                        }
                        else {
                            leftMost=cur.right;
                            findLeft=true;
                            nextPre=cur.right;
                        }
                    }
                    else {
                        if (cur.left!=null){
                            nextPre.next=cur.left;
                            nextPre=cur.left;
                            if (cur.right!=null){
                                cur.left.next=cur.right;
                                nextPre=cur.right;
                            }
                        }
                        else {
                            nextPre.next=cur.right;
                            nextPre=cur.right;
                        }
                    }
                }
                else {
                    if (findLeft==false){
                        leftMost=null;
                    }
                    cur=cur.next;
                    continue;
                }
                cur=cur.next;
            }

        }
        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
