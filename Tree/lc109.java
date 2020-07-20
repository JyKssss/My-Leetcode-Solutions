package Tree;

import java.util.ArrayList;
import java.util.List;

public class lc109 {
    /**
     * 找中点递归 时间开销太大了 可以直接转存到动态数组中
     * @param head
     * @return
     */

    public TreeNode sortedListToBST(ListNode head) {
        ListNode start=head;
        int length=0;
        while (start!=null){
            length++;
            start=start.next;
        }
        return helper(head, length);
    }
    public TreeNode helper(ListNode head, int length){
        if (length==0)return null;
        if (length==1)return new TreeNode(head.val);
        int mid=length/2;
        ListNode left=head;
        for (int i = 0; i < mid; i++) {
            head=head.next;
        }
        TreeNode root=new TreeNode(head.val);
        root.left=helper(left, mid);
        root.right=helper(head.next,length-mid);
        return root;
    }

    /**
     * 用数组代替 可以再加入起始和终止index节省空间
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> numsList=new ArrayList<>();
        while (head!=null){
            numsList.add(head.val);
            head=head.next;
        }
        return helper(numsList);
    }

    public TreeNode helper(List<Integer>nums){
        if (nums.size()==0)return null;
        if (nums.size()==1)return new TreeNode(nums.get(0));
        int mid=(nums.size()-1)/2;
        TreeNode root=new TreeNode(nums.get(mid));
        root.left=helper(nums.subList(0, mid));
        root.right=helper(nums.subList(mid+1, nums.size()));
        return root;
    }


    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
