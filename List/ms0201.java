package List;

import java.util.HashSet;

public class ms0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode prev=null,cur=head;
        HashSet<Integer>nodeSet=new HashSet<>();
        while (cur!=null){
            if (nodeSet.contains(cur.val)){
                prev.next=cur.next;
                cur=cur.next;
            }
            else {
                nodeSet.add(cur.val);
                prev=cur;
                cur=cur.next;
            }
        }
        return head;
    }

    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
