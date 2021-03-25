package List;

public class lc92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n)return head;
        int index=1;
        ListNode preStart=new ListNode(-1),start=head,pre=null,cur,tmp;
        while (index<m){
            preStart=start;
            start=start.next;
            index++;
        }
        cur=start;
        // System.out.println("start cur "+cur.val+" preStart "+preStart.val);
        for (int i = 0; i < n-m+1; i++) {
            if (i==0){
                pre=cur;
                cur=cur.next;
                continue;
            }
            tmp=cur;
            cur=cur.next;
            tmp.next=pre;
            pre=tmp;
            // System.out.println("pre "+pre.val+"cur "+cur.val);
        }
        start.next=cur;
        preStart.next=pre;
        if (m==1)return pre;
        return head;
    }

    /**
     * Recursion solution
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m==1){
            return reverseN(head, n);
        }
        head.next=reverseBetween2(head.next, m-1, n-1);
        return head;
    }
    ListNode successor=null;
    public ListNode reverseN(ListNode head, int n){
        if (n==1){
            successor=head.next;
            return head;
        }

        ListNode last=reverseN(head.next, n-1);
        head.next.next=head;
        head.next=successor;
        return last;

    }




    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
