package List;

public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        while (curA!=null){
            curA.val=-curA.val;
            curA=curA.next;
        }
        while (curB!=null && curB.val>=0){
            curB=curB.next;
        }
        curA=headA;
        while (curA!=null){
            curA.val=-curA.val;
            curA=curA.next;
        }
        return curB;
    }

    /**
     * 不修改原链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA=headA,pB=headB;
        if (pA==null||pB==null){
            return null;
        }

        while (pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
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
