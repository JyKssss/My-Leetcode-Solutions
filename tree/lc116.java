package tree;

import java.util.Deque;
import java.util.LinkedList;

public class lc116 {
    /**
     * 层序遍历 空间复杂度On
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root==null)return null;
        Deque<Node>line =new LinkedList<>();
        Node cur=root,pre=null;
        int size;
        line.addLast(cur);
        while (!line.isEmpty()){
            size=line.size();
            for (int i = 0; i < size; i++) {
                cur=line.pollFirst();
                if (cur.left!=null)line.addLast(cur.left);
                if (cur.right!=null)line.addLast(cur.right);
                if (i==0&&i!=size-1){
                    pre=cur;
                    continue;
                }
                else if (i==0&&i==size-1){
                    cur.next=null;
                    continue;
                }
                else if (i<size-1){
                    pre.next=cur;
                    pre=cur;
                }
                else {
                    pre.next=cur;
                    cur.next=null;
                }
            }
        }
        return root;
    }

    /**
     * 每一层节点负责连接下一层节点
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root==null){
            return root;
        }
        Node leftMost=root;
        Node pre=null;
        while (leftMost!=null){
            Node cur=leftMost;
            if (cur.left==null)break;
//            leftMost=leftMost.left;
            while (cur!=null){
                cur.left.next=cur.right;
                if (cur.equals(leftMost)){
                    pre=cur.right;
                    cur=cur.next;
                    continue;
                }
                pre.next=cur.left;
                pre=cur.right;
                cur=cur.next;
            }
            leftMost=leftMost.left;
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
