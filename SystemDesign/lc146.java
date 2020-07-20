package SystemDesign;

import java.util.HashMap;
import java.util.HashSet;

public class lc146 {
}
/*
用hashmap加双向链表的方式
双向链表实时更新位置
 */
class LRUCache {
    int capacity;
    HashMap<Integer,Node>hashMap;
    Node start,end;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.hashMap=new HashMap<>();
        start=new Node(-1, -1);
        end=new Node(-1, -1);
        start.next=end;
        end.prev=start;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key))return -1;
        else if (start.next.key!=key){
            Node node=hashMap.get(key);
            Node first=start.next;
            node.prev.next=node.next;
            node.next.prev=node.prev;
            start.next=node;
            node.prev=start;
            node.next=first;
            first.prev=node;
            System.out.println("key "+key);
            return node.val;
        }
        else return hashMap.get(key).val;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)){
            Node node=hashMap.get(key);
            node.val=value;
            if (start.next.key!=key ){
                Node first2=start.next;
                node.prev.next=node.next;
                node.next.prev=node.prev;
                start.next=node;
                node.prev=start;
                node.next=first2;
                first2.prev=node;
            }
        }
        else if (hashMap.size()<capacity){
            Node node=new Node(key, value);
            hashMap.put(key, node);
            node.prev=start;
            node.next=start.next;
            start.next=node;
            node.next.prev=node;
        }
        else {
            Node node=new Node(key, value);

            Node last=end.prev;
            end.prev=last.prev;
            last.prev.next=end;
            hashMap.remove(last.key);

            hashMap.put(key, node);
            node.prev=start;
            node.next=start.next;
            start.next=node;
            node.next.prev=node;
        }

        System.out.println("key "+key+"value "+value);
    }
}

class Node{
    int key;
    int val;
    Node prev,next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}