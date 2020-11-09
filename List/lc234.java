package List;


public class lc234 {
    /**
     * 快慢指针找到链表的中点 将中点以后的链表翻转 之后比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode s=head,f=head,middle;
        while (f!=null){
            s=s.next;
            f=f.next;
            if (f!=null)f=f.next;
        }
        middle=reverse(s);
        boolean res=true;
        while (middle!=null){
            if (middle.val!= head.val)return false;
            middle=middle.next;
            head=head.next;
        }
        return res;
    }
    private ListNode reverse(ListNode head){
        ListNode pre=null,cur=head,next;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
