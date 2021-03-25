package SystemDesign;

import javafx.util.Pair;

import java.util.Iterator;
import java.util.LinkedList;

public class lc706 {

}

class MyHashMap {
    static final int base=769;
    LinkedList<int[]>[]dataList;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.dataList=new LinkedList[base];
    }

    private int findKey(int key){
        return key % base;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int loc=findKey(key);
        if (dataList[loc]==null){
            dataList[loc]=new LinkedList<>();
            int[] pair=new int[]{key,value};
            dataList[loc].add(pair);
        }
        else {
            LinkedList<int[]>cur=dataList[loc];
            for(int[] c:cur){
                if (c[0]==key){
                    c[1]=value;
                    return;
                }
            }
            cur.add(new int[]{key,value});
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int loc=findKey(key);
        if (dataList[loc]==null){
            return -1;
        }
        else {
            LinkedList<int[]>cur=dataList[loc];
            for(int[] c:cur){
                if (c[0]==key){
                    return c[1];
                }
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int loc=findKey(key);
        if (dataList[loc]!=null){
            LinkedList<int[]>cur=dataList[loc];
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i)[0]==key){
                    cur.remove(i);
                    break;
                }
            }
        }
    }
}