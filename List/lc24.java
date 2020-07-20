package List;

public class lc24 {
    /**
     * 递归翻转链表
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode cur=head,cur2=null;
        if (cur!=null&&cur.next!=null){
            cur2=cur.next;
            cur.next=swapPairs(cur2.next);
            cur2.next=cur;
            return cur2;
        }
        else return cur;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
