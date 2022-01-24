package List;

import java.util.Stack;

public class lc143 {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        int step = stack.size() / 2;
        while (step > 0) {
            ListNode tmpNode = cur.next;
            cur.next = stack.pop();
            cur.next.next = tmpNode;
            cur = cur.next.next;
            step -= 1;
        }
        cur.next = null;
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
