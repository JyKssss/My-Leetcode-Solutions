package List;

public class lc430 {
    /**
     * 看成是二叉树的先序遍历 递归解法
     * @param head
     * @return
     */
    Node prev=null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public void dfs(Node head){
        if (head==null)return;
        Node next=head.next;
        if (prev!=null){
            prev.next=head;
            head.prev=prev;
        }
        prev=head;
        dfs(head.child);
        head.child=null;
        dfs(next);
    }

    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
