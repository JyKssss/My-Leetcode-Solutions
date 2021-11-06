package SystemDesign;

public class lc622 {

}
class MyCircularQueue {

    public MyCircularQueue(int k) {
        this.limit = k;
        this.size = 0;
        head = new node(-1);
        end = head;
        for (int i = 1; i < k; i++) {
            end.next = new node(-1);
            node tmp = end;
            end = end.next;
            end.prev = tmp;
        }
        end.next = head;
        head.prev = end;
        end = head;
    }

    public boolean enQueue(int value) {
        if (!isFull()){
            if (!isEmpty()){
                end = end.next;
            }
            size += 1;
            end.setVal(value);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()){
            head.setVal(-1);
            head = head.next;
            if (size == 1){
                end = head;
            }
            size -= 1;
            return true;
        }
        else {
            return false;
        }
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return end.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= limit;
    }

    int size;
    int limit;
    node head, end;

    private class node {
        int val;
        node prev;
        node next;

        node (int val){
            this.val = val;
            prev = null;
            next = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public node getPrev() {
            return prev;
        }

        public void setPrev(node prev) {
            this.prev = prev;
        }

        public node getNext() {
            return next;
        }

        public void setNext(node next) {
            this.next = next;
        }
    }
}