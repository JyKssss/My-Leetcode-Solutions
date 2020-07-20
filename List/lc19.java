package List;

public class lc19 {
    /**
     * 快慢指针 快指针先走n步
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)return head;
        ListNode pre=head,slow=head,fast=head;
        int index=0;
        while (index<n){
            fast=fast.next;
            index++;
        }
        if (fast==null){
            return pre.next;
        }

        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if (slow.next!=null&&slow.next.next!=null){
            slow.next=slow.next.next;
        }
        else if (slow.next!=null&&slow.next.next==null){
            slow.next=null;
        }
        return pre;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
