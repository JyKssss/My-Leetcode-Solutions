package List;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode(-1), cur = head;
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (ListNode node : lists) {
            if (node !=null) {
                heap.offer(node);
            }
        }

        while (heap.size() > 0) {
            ListNode node = heap.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return head.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
