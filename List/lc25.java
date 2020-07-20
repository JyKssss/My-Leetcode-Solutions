package List;

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0,numK,len=0;
        ListNode pre=null,cur=head,next,start=null,end=null,preEnd=new ListNode(0),resStart=preEnd;
        while (head!=null){
            len++;
            head=head.next;
        }
        numK=len/k;
        while (cur!=null && numK>0){
            while (count<k&&cur!=null){
                if (count>0&&count<k-1){
                    next=cur.next;
                    cur.next=pre;
                    pre=cur;
                    cur=next;
                    count++;
                    System.out.println(">0 <k "+pre.val);
                }
                else if (count==0){
                    end=cur;
                    next=cur.next;
                    pre=cur;
                    cur=next;
                    count++;
                    System.out.println("==0 "+pre.val);
                }
                else if (count==k-1&&cur.next!=null){
                    start=cur;
                    next=cur.next;
                    cur.next=pre;
//                    pre=cur;
                    cur=next;
                    count++;
                    System.out.println("==k-1 "+start.val);
                }
                else if (cur.next==null){

                    start=cur;
                    count++;
                    cur=cur.next;
                    System.out.println("==null "+start.val);
                    break;
                }
            }
            numK--;
            preEnd.next=start;
            preEnd=end;
            count=0;
        }
        preEnd.next=cur;
        return resStart.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
