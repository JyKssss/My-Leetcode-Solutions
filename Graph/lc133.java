package Graph;

import java.util.*;

public class lc133 {
    HashMap<Integer,Node>map=new HashMap<>();
    Set<Integer>set=new HashSet<>();
    public Node cloneGraph(Node node) {
        if (node==null)return null;
        Node root=new Node(node.val);
        map.put(root.val, root);
        set.add(root.val);
        dfs(node, root);
        return root;
    }

    public void dfs(Node old, Node replica){
        List<Node>neighbors=old.neighbors;
        for(Node n: neighbors){
            int val=n.val;
            Node neighbor=null;
            if (map.containsKey(val)){
                neighbor=map.get(val);
                replica.neighbors.add(neighbor);
            }else {
                neighbor=new Node(val);
                replica.neighbors.add(neighbor);
                map.put(val, neighbor);
            }
            if(!set.contains(val)){
                set.add(val);
                dfs(n, neighbor);
            }
        }
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
