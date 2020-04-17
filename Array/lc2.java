package Array;

/**
 * 递归计算每一位数 需要考虑进位 所以用一个辅助函数
 */
public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }
    public ListNode helper(ListNode l1,ListNode l2,int add){
        if (l1==null&&l2==null&&add==0)return null;
        if (l1==null&&l2==null&&add==1)return new ListNode(add);
        int nextAdd=0;
        int val;
        if (l1!=null&&l2!=null)val=l1.val+l2.val;
        else if (l1!=null)val=l1.val;
        else val=l2.val;
        val+=add;
        if (val>=10){
            nextAdd=1;
            val=val%10;
        }


        ListNode cur=new ListNode(val);
        if (l1==null||l2==null){
            if (l1==null){
                cur.next=helper(null, l2.next, nextAdd);
            }
            else cur.next=helper(l1.next, null, nextAdd);
        }
        else {
            cur.next=helper(l1.next, l2.next,nextAdd);
        }

        return cur;
    }
    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
