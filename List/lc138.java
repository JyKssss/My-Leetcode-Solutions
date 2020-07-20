package List;

import java.util.HashMap;

public class lc138 {
    /*
    建立索引和值的映射 值是可以重复的
     */
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        int index=0;
        Node start=null,cur=head,pre=null;
        HashMap<Integer,Node>indexNode=new HashMap<>();//储存新链表中超前值
        HashMap<Integer,Node>curMap=new HashMap<>();//储存新链表中已放入的值
        HashMap<Node,Integer>nodeIndex=new HashMap<>();//存储原链表值键对 map
        while (cur!=null){
            nodeIndex.put(cur, index);
            index++;
            cur=cur.next;
        }
        index=0;
        start=new Node(-1);
        pre=start;
        while (head!=null){
            if (!indexNode.containsKey(index)){
                cur=new Node(head.val);
                pre.next=cur;
            }
            else {
                cur=indexNode.get(index);
                pre.next=cur;
            }

            if (head.random==null){
                cur.random=null;
            }
            else if (nodeIndex.get(head.random)>index&&!indexNode.containsKey(nodeIndex.get(head.random))){
                Node random=new Node(head.random.val);
                cur.random=random;
                indexNode.put(nodeIndex.get(head.random), random);
            }
            else if (nodeIndex.get(head.random)>index&&indexNode.containsKey(nodeIndex.get(head.random))){
                cur.random=indexNode.get(nodeIndex.get(head.random));
            }
            else if (nodeIndex.get(head.random)==index){
                cur.random=cur;
            }
            else if (nodeIndex.get(head.random)<index){
                cur.random=curMap.get(nodeIndex.get(head.random));
            }
            curMap.put(index, cur);
            index++;
            pre=cur;
            head=head.next;
        }
        return start.next;
    }

    /**
     * 时间复杂度On 空间复杂度O1的解法
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head==null)return null;
        Node cur=head,start=null,cur2,pre2=null;
        /**
         * 把原链表进行复制并把新节点插入链表
         */
        while (cur!=null){
            Node addNode=new Node(cur.val);
            addNode.next=cur.next;
            cur.next=addNode;
            cur=addNode.next;
        }
        cur=head;
        /*
        复制每个节点的random node
         */
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;
            }
            else cur.next.random=null;
            cur=cur.next.next;
        }
        cur=head;
        start=null;
        while (cur!=null){
            cur2=cur.next;
            cur.next=cur2.next;
            if (start==null){
                start=cur2;

            }
            else {
                pre2.next=cur2;
            }
            pre2=cur2;
            cur=cur.next;
        }
        return start;

    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
