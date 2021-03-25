package List;

public class lc83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prevNode=head, curNode=head.next;
        while (curNode!=null){
            if (curNode.val==prevNode.val){
                prevNode.next=curNode.next;
            }
            else {
                prevNode=curNode;
            }
            curNode=curNode.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
