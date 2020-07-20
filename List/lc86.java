package List;

public class lc86 {
    public ListNode partition(ListNode head, int x) {
        //两个哨兵节点
        ListNode smallHead=new ListNode(-1),smallCur=smallHead;
        ListNode largeHead=new ListNode(-1),largeCur=largeHead;
        while (head!=null){
            if (head.val<x){
                smallCur.next=head;
                smallCur=smallCur.next;
            }
            else {
                largeCur.next=head;
                largeCur=largeCur.next;
            }
            head=head.next;
        }
        if (smallHead.next!=null){
            smallCur.next=largeHead.next;
            if (largeHead.next!=null){
                largeCur.next=null;
            }
            return smallHead.next;
        }
        else {
            return largeHead.next;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
