package List;

public class lc61 {
    /**
     * 找到新鏈錶的尾節點 斷開重連接
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)return head;
        ListNode cur=head, end=null;
        int len=0;
        while (cur.next!=null){
            len++;
            cur=cur.next;
        }
        end=cur;
        cur=head;
        len++;
        int moveStep=k%len,index=0;
        while (index<len-moveStep){
            index++;
            cur=cur.next;
        }
        end.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
