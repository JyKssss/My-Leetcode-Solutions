package List;

public class lc21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start=null;
        if (l1==null&&l2==null)return l1;
        else if (l1==null){
            start=l2;
            l2=l2.next;
        }
        else if (l2==null){
            start=l1;
            l1=l1.next;
        }
        else {
            start=l1.val>l2.val?l2:l1;
            if (l1.val>l2.val)l2=l2.next;
            else l1=l1.next;
        }

        ListNode pre=start;
        while (l1!=null || l2!=null){
            if (l1!=null&&l2!=null){
                pre.next=l1.val>l2.val?l2:l1;
                if (l1.val>l2.val)l2=l2.next;
                else l1=l1.next;
                pre=pre.next;
            }
            else if (l1!=null){
                pre.next=l1;
                break;
            }
            else {
                pre.next=l2;
                break;
            }
        }
        return start;
    }
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
