package List;

public class lc141 {
    public boolean hasCycle(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode pre;
        while (head!=null){
            if (head.next==dummy)return true;
            pre=head;
            head=head.next;
            pre.next=dummy;
        }
        return false;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
