package List;

public class lc142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sCur = head;
        ListNode fCur = head;
        boolean isCircle = false;
        while (fCur.next != null && fCur.next.next != null) {
            fCur = fCur.next.next;
            sCur = sCur.next;
            if (fCur == sCur) {
                isCircle = true;
                break;
            }
        }
        if (!isCircle) {
            return null;
        }
        ListNode newCur = head;
        while (newCur != sCur) {
            newCur = newCur.next;
            sCur = sCur.next;
        }
        return sCur;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
