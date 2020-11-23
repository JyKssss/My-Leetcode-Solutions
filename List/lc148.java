package List;

public class lc148 {
    //归并排序
    public ListNode sortList(ListNode head) {
        return divide(head);
    }

    public ListNode divide(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode l1,l2,cur=head;
        int length=0;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        cur=head;
        for (int i = 0; i < length/2; i++) {
            if (i==(length/2)-1){
                ListNode tmp=cur;
                cur=cur.next;
                tmp.next=null;
                break;
            }
            cur=cur.next;
        }
        l1=divide(head);
        l2=divide(cur);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode h1,ListNode h2){
        if (h1==null&&h2==null)return null;
        else if (h1==null)return h2;
        else if (h2==null)return h1;
        ListNode head,cur;
        head=h1.val<=h2.val?h1:h2;
        cur=head;
        if (h1.val<=h2.val)h1=h1.next;
        else h2=h2.next;
        while (h1!=null||h2!=null){
            if (h1!=null&&h2!=null){
                cur.next=h1.val<=h2.val?h1:h2;
                cur=cur.next;
                if (h1.val<=h2.val)h1=h1.next;
                else h2=h2.next;
            }
            else if (h1!=null){
                cur.next=h1;
                h1=h1.next;
                cur=cur.next;
            }
            else {
                cur.next=h2;
                h2=h2.next;
                cur=cur.next;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
