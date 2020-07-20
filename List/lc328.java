package List;

public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null)return head;
        ListNode curOdd,curEven,oddHead,evenHead;
        oddHead=head;
        evenHead=head.next;
        curOdd=oddHead;
        curEven=evenHead;
        while (curOdd!=null&&curEven!=null&&curEven.next!=null){
            curOdd.next=curEven.next;
            curOdd=curOdd.next;
            curEven.next=curOdd.next;
            curEven=curEven.next;
        }
        curOdd.next=evenHead;
        return oddHead;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
