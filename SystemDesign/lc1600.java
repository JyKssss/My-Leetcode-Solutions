package SystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc1600 {
    class ThroneInheritance {
        HashSet<String>isDead;
        HashMap<String,Node>nodeMap;
        List<String>order;
        Node king;

        public ThroneInheritance(String kingName) {
            this.king=new Node(kingName);
            this.nodeMap=new HashMap<>();
            this.isDead=new HashSet<>();
            nodeMap.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            Node parent=nodeMap.get(parentName);
            Node child=new Node(childName);
            nodeMap.put(childName, child);
            parent.children.add(child);
        }

        public void death(String name) {
            isDead.add(name);
        }

        public List<String> getInheritanceOrder() {
            this.order=new ArrayList<>();
            dfs(king.name);
            return order;
        }
        private void dfs(String name){
            Node node=nodeMap.get(name);
            List<Node>children= node.children;
            if (!isDead.contains(name)){
                order.add(name);
            }
            for (Node child : children) {
                dfs(child.name);
            }
        }


    }

    private class Node{
        String name;
        List<Node>children;

        public Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }
}


