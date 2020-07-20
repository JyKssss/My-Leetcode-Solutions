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

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
