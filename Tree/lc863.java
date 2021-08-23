package Tree;

import java.util.*;

public class lc863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,List<Integer>>nodeMap=new HashMap<>();
        Deque<TreeNode>list=new LinkedList<>();
        list.addLast(root);
        int size;
        while (list.size()>0){
            size=list.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=list.pollFirst();
                List<Integer> linkedNodeList=null;
                if (cur.left!=null){
                    linkedNodeList= nodeMap.getOrDefault(cur.val,new LinkedList<>());
                    linkedNodeList.add(cur.left.val);
                    nodeMap.put(cur.val, linkedNodeList);
                    linkedNodeList=new LinkedList();
                    linkedNodeList.add(cur.val);
                    nodeMap.put(cur.left.val, linkedNodeList);
                    list.addLast(cur.left);
                }
                if (cur.right!=null){
                    linkedNodeList= nodeMap.getOrDefault(cur.val,new LinkedList<>());
                    linkedNodeList.add(cur.right.val);
                    nodeMap.put(cur.val, linkedNodeList);
                    linkedNodeList=new LinkedList();
                    linkedNodeList.add(cur.val);
                    nodeMap.put(cur.right.val, linkedNodeList);
                    list.addLast(cur.right);
                }
            }
        }
        LinkedList<Integer>nodeList=new LinkedList<>();
        nodeList.add(target.val);
        HashSet<Integer>visitedSet=new HashSet<>();
        visitedSet.add(target.val);
        for (int i = 0; i < k && nodeList.size()>0; i++) {
            size=nodeList.size();
            for (int j = 0; j < size; j++) {
                List<Integer>linkedList=nodeMap.get(nodeList.pollFirst());
                if (linkedList==null){
                    continue;
                }
                for (Integer nodeN : linkedList) {
                    if (!visitedSet.contains(nodeN)){
                        visitedSet.add(nodeN);
                        nodeList.addLast(nodeN);
                    }
                }
            }
        }
        return nodeList;
    }
}
