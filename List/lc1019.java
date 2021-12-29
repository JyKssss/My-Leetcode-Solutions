package List;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> stack = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (stack.size() == 0 || stack.peekLast()[0] >= cur.val) {
                stack.addLast(new int[]{cur.val, index});
                resList.add(0);
            } else  {
                while (stack.size() > 0 && stack.peekLast()[0] < cur.val) {
                    int[] last = stack.pollLast();
                    resList.set(last[1], cur.val);
                }
                stack.addLast(new int[]{cur.val, index});
                resList.add(0);
            }
            cur = cur.next;
            index += 1;
        }
        int[] res =new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
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
