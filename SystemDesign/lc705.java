package SystemDesign;

import java.util.LinkedList;

public class lc705 {

}

class MyHashSet {
    static final int base=769;
    LinkedList<Integer>[] dataList;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.dataList=new LinkedList[base];
    }

    private int findKey(int key){
        return key % base;
    }

    public void add(int key) {
        int loc=findKey(key);
        if (dataList[loc]==null){
            dataList[loc]=new LinkedList<>();
        }
        if (dataList[loc].contains(key)){
            return;
        }
        dataList[loc].addFirst(key);
    }

    public void remove(int key) {
        int loc=findKey(key);
        if (dataList[loc]==null|| !dataList[loc].contains(key)){
            return;
        }
        else {
            dataList[loc].remove(dataList[loc].indexOf(key));
            return;
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int loc=findKey(key);
        if (dataList[loc]==null){
            return false;
        }
        else {
            return dataList[loc].contains(key);
        }
    }
}
