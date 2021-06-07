package List;

public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        while (curA!=null){
            curA.val=-curA.val;
            curA=curA.next;
        }
        while (curB!=null && curB.val>0){
            curB=curB.next;
        }
        curA=headA;
        while (curA!=null){
            curA.val=-curA.val;
            curA=curA.next;
        }
        return curB;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
