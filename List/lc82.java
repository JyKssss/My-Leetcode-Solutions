package List;

public class lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode h=new ListNode(),prevNode=h,curNode=head;
        h.next=head;
        int replicaNum = Integer.MIN_VALUE;
        while (curNode!=null){
            if ((curNode.next!=null&&curNode.val==curNode.next.val)||curNode.val==replicaNum){
                prevNode.next=curNode.next;
                replicaNum=curNode.val;
            }else {
                prevNode=curNode;
            }
            curNode=curNode.next;
        }
        return h.next;
    }

    public class ListNode {
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
