package List;

public class lc876 {
    public ListNode middleNode(ListNode head) {
        ListNode end=head,mid=head;
        int index=0;
        while (end!=null){
            end=end.next;
            if (index%2==1)mid=mid.next;
            index++;
        }
        return mid;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
