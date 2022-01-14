package Math;

public class lc382 {

}
class Solution {
    int threshold = 1;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode cur = head;
        int count = 0;
        int res = 0;
        while (cur != null) {
            count += 1;
            int random = (int)(Math.random() * count);
            System.out.println(random);
            if (random < threshold) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
    
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