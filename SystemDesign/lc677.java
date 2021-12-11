package SystemDesign;

import java.util.HashMap;

public class lc677 {
}
class MapSum {

    Node root;
    HashMap<String, Integer> cntMap;

    public MapSum() {
        root = new Node();
        cntMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int deltaVal = 0;
        if (cntMap.containsKey(key)) {
            deltaVal = val - cntMap.get(key);
            cntMap.replace(key, val);
        }
        else {
            cntMap.put(key, val);
            deltaVal = val;
        }
        Node curNode = root;
        for (int i = 0; i < key.length(); i++) {
            int curIndex = key.charAt(i) - 'a';
            curNode.val += deltaVal;
            if (curNode.children[curIndex] == null) {
                curNode.children[curIndex] = new Node();
            }
            curNode = curNode.children[curIndex];
        }
        curNode.val += deltaVal;
    }

    public int sum(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int curIndex = prefix.charAt(i) - 'a';
            if (curNode.children[curIndex] == null){
                return 0;
            }
            curNode = curNode.children[curIndex];
        }
        return curNode.val;
    }

    private class Node {

        boolean isEnd;
        Node[] children;
        int val;
        public Node() {
            this.isEnd = false;
            this.children = new Node[26];
            val = 0;
        }


    }
}

