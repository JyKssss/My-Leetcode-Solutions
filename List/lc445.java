package List;

public class lc445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        while (l1!=null) {
            System.out.println("l1: "+l1.val);
            l1=l1.next;
        }
        while (l2!=null) {
            System.out.println("l2: "+l2.val);
            l2=l2.next;
        }
        return reverse(helper(l1, l2, 0));
    }
    public ListNode helper(ListNode l1,ListNode l2,int add){
        if (l1==null&&l2==null){
            if (add==1)return new ListNode(add);
            else return null;
        }
        int val;
        if (l1!=null&&l2!=null){
            val=l1.val+l2.val+add;
        }
        else if (l1!=null){
            val=l1.val+add;
        }
        else {
            val=l2.val+add;
        }

        if (val>=10){
            val=val%10;
            add=1;
        }
        else add=0;
        ListNode node=new ListNode(val);
        if (l1!=null&&l2!=null){
            if (l1.next!=null&&l2.next!=null){
                node.next=helper(l1.next, l2.next, add);
            }
            else if (l1.next!=null){
                node.next=helper(l1.next, null, add);
            }
            else if (l2.next!=null){
                node.next=helper(null, l2.next, add);
            }
            else {
                node.next=helper(null, null, add);
            }
        }
        else if (l1!=null){
            node.next=helper(l1.next, null, add);
        }
        else {
            node.next=helper(null, l2.next, add);
        }
        return node;
    }
    public ListNode reverse(ListNode l){
        ListNode pre=null,tmp=null;
        while (l!=null){
            tmp=l.next;
            l.next=pre;
            pre=l;
            l=tmp;
            if (l==null){
                l=pre;
                break;
            }
        }
        return l;
    }
    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
